package mediums

import "fmt"

// User interface to handle user actions
type User interface {
	Describe()
}

type user struct {
	name    string
	address string
}

// Describe method to print details of user object
func (usr *user) Describe() {
	fmt.Printf("user %s from %s\n", usr.name, usr.address)
}

// SetUsers method to initialize the user structs
func SetUsers() (student, teacher, principal User) {
	student = &user{name: "siva", address: "banglore"}
	teacher = &user{name: "vishnu", address: "hyderabad"}
	principal = &user{name: "brahmi", address: "vellore"}
	return
}
