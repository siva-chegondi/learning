package toystore

import (
	"context"
	"github.com/siva-chegondi/learning/golang/learning/toystore/api"
	"log"
)

type ToyStore interface {
	BuyToy(toyId int, sessionCtx context.Context) error
}

var logger = log.Default()

type toystore struct {
	storeAPI api.StoreAPI
}

func NewToyStore(storeAPI api.StoreAPI) ToyStore {
	return &toystore{storeAPI: storeAPI}
}

// BuyToy
// Method to buy a toy from the store
// by user from sessionCtx
func (t toystore) BuyToy(toyId int, sessionCtx context.Context) error {
	logger.Printf("Starting purchase of toy %v from the store", toyId)
	userId := sessionCtx.Value("user-id")
	return t.storeAPI.BuyToy(toyId, userId.(int))
}
