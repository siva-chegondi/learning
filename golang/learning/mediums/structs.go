package mediums

import "fmt"

type User struct {
	name    string
	address string
}

func (user *User) Describe() {
	fmt.Printf("User %s from %s\n", user.name, user.address)
}

func SetUsers() (student, teacher, principal *User) {
	student = &User{name: "siva", address: "banglore"}
	teacher = &User{name: "vishnu", address: "hyderabad"}
	principal = &User{name: "brahmi", address: "vellore"}
	return
}
