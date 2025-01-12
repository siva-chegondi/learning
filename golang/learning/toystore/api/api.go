package api

import (
	"encoding/json"
	"net/http"
	"strings"
)

type StoreAPI interface {
	BuyToy(toyId, userId int) error
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

	data, _ := json.Marshal(&PurchaseRecord{
		purchaseId: "dummy-unique-uuid",
		toyId:      toyId,
		userId:     userId,
	})
	reader := strings.NewReader(string(data))
	_, err := api.httpClient.Post("/api/toystore/buy", "application/json", reader)
	return err
}
