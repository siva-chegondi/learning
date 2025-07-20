package toystore

import (
	"context"
	"github.com/siva-chegondi/learning/golang/learning/toystore/mock_api"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/suite"
	"go.uber.org/mock/gomock"
	"testing"
)

type ToyStoreTestSuite struct {
	suite.Suite

	ctrl      *gomock.Controller
	apiClient *mock_api.MockStoreAPI

	toyStore ToyStore
}

func (s *ToyStoreTestSuite) SetupSuite() {
	s.ctrl = gomock.NewController(s.T())
	s.apiClient = mock_api.NewMockStoreAPI(s.ctrl)

	s.toyStore = NewToyStore(s.apiClient)
}

func (s *ToyStoreTestSuite) TearDownSuite() {
	s.ctrl.Finish()
}

func (s *ToyStoreTestSuite) TestBuyToy() {
	// mock api call to the expected result
	s.apiClient.EXPECT().BuyToy(gomock.Any(), gomock.Any()).Return(nil)

	// Internally BuyToy is calling Generate and
	// sending email invitation asynchronously.

	// Following expectation may get called 0 or 1 time based on the execution time.
	// so using AnyTimes() to expect it 0 or more times.
	s.apiClient.EXPECT().GenerateAndSendInvoice(gomock.Any()).AnyTimes().Return(nil)
	err := s.toyStore.BuyToy(100, context.WithValue(context.Background(), "user-id", 213))
	assert.Nil(s.T(), err)
}

func TestToyStoreSuite(t *testing.T) {
	suite.Run(t, new(ToyStoreTestSuite))
}
