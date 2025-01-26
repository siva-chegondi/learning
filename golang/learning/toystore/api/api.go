package api

import (
	"encoding/json"
	"net/http"
	"strings"
)

type StoreAPI interface {
	BuyToy(toyId, userId int) error
	GenerateAndSendInvoice(order PurchaseRecord) error
}

type PurchaseRecord struct {
	purchaseId string
	toyId      int
	userId     int
}

type APIClient struct {
	httpClient *http.Client
}

func (api *APIClient) BuyToy(toyId, userId int) error {

	purchaseRecord := &PurchaseRecord{
		purchaseId: "dummy-unique-uuid",
		toyId:      toyId,
		userId:     userId,
	}
	data, _ := json.Marshal(purchaseRecord)
	reader := strings.NewReader(string(data))
	_, err := api.httpClient.Post("/api/toystore/buy", "application/json", reader)
	if err == nil {
		go api.GenerateAndSendInvoice(purchaseRecord)
	}
	return err
}

func (api *APIClient) GenerateAndSendInvoice(order *PurchaseRecord) error {
	data, _ := json.Marshal(order)
	reader := strings.NewReader(string(data))
	_, err := api.httpClient.Post("/api/toystore/mail-invoice", "application/json", reader)
	return err
}
