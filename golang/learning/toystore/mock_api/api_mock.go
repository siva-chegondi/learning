// Code generated by MockGen. DO NOT EDIT.
// Source: toystore/api/api.go
//
// Generated by this command:
//
//	mockgen -source toystore/api/api.go -destination toystore/mock_api/api_mock.go
//

// Package mock_api is a generated GoMock package.
package mock_api

import (
	reflect "reflect"

	api "github.com/siva-chegondi/learning/golang/learning/toystore/api"
	gomock "go.uber.org/mock/gomock"
)

// MockStoreAPI is a mock of StoreAPI interface.
type MockStoreAPI struct {
	ctrl     *gomock.Controller
	recorder *MockStoreAPIMockRecorder
	isgomock struct{}
}

// MockStoreAPIMockRecorder is the mock recorder for MockStoreAPI.
type MockStoreAPIMockRecorder struct {
	mock *MockStoreAPI
}

// NewMockStoreAPI creates a new mock instance.
func NewMockStoreAPI(ctrl *gomock.Controller) *MockStoreAPI {
	mock := &MockStoreAPI{ctrl: ctrl}
	mock.recorder = &MockStoreAPIMockRecorder{mock}
	return mock
}

// EXPECT returns an object that allows the caller to indicate expected use.
func (m *MockStoreAPI) EXPECT() *MockStoreAPIMockRecorder {
	return m.recorder
}

// BuyToy mocks base method.
func (m *MockStoreAPI) BuyToy(toyId, userId int) error {
	m.ctrl.T.Helper()
	ret := m.ctrl.Call(m, "BuyToy", toyId, userId)
	ret0, _ := ret[0].(error)
	return ret0
}

// BuyToy indicates an expected call of BuyToy.
func (mr *MockStoreAPIMockRecorder) BuyToy(toyId, userId any) *gomock.Call {
	mr.mock.ctrl.T.Helper()
	return mr.mock.ctrl.RecordCallWithMethodType(mr.mock, "BuyToy", reflect.TypeOf((*MockStoreAPI)(nil).BuyToy), toyId, userId)
}

// GenerateAndSendInvoice mocks base method.
func (m *MockStoreAPI) GenerateAndSendInvoice(order api.PurchaseRecord) error {
	m.ctrl.T.Helper()
	ret := m.ctrl.Call(m, "GenerateAndSendInvoice", order)
	ret0, _ := ret[0].(error)
	return ret0
}

// GenerateAndSendInvoice indicates an expected call of GenerateAndSendInvoice.
func (mr *MockStoreAPIMockRecorder) GenerateAndSendInvoice(order any) *gomock.Call {
	mr.mock.ctrl.T.Helper()
	return mr.mock.ctrl.RecordCallWithMethodType(mr.mock, "GenerateAndSendInvoice", reflect.TypeOf((*MockStoreAPI)(nil).GenerateAndSendInvoice), order)
}
