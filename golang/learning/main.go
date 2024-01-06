package main

import (
	"fmt"
	"jokrhat/learning/basics"
	"jokrhat/learning/mediums"
)

func main() {
	// basic type conversion
	basics.Types()
	fmt.Println("------------------------")

	// Go pointers
	basics.Pointers()
	fmt.Println("------------------------")

	// Go Struct
	student, teacher, principal := mediums.SetUsers()
	student.Describe()
	teacher.Describe()
	principal.Describe()
	fmt.Println("------------------------")
}
