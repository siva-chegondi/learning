package main

import (
	"fmt"
	"jokrhat/learning/basics"
	"jokrhat/learning/mediums"
)

const divider = "-------------------------"

func main() {
	// basic type conversion
	basics.Types()
	fmt.Println(divider)

	// Go pointers
	basics.Pointers()
	fmt.Println(divider)

	// Go Struct
	student, teacher, principal := mediums.SetUsers()
	student.Describe()
	teacher.Describe()
	principal.Describe()
	fmt.Println(divider)

	// Go Generics
	var wholeNumbers []int32 = make([]int32, 10)
	for i := range wholeNumbers {
		wholeNumbers[i] = int32(i)
	}
	fmt.Println("Generics Example Usage\nFor more details go the mediums package generics.go file")
	fmt.Printf("\nAddition of whole numbers: %v\n", mediums.SumGeneric(wholeNumbers))
	fmt.Printf("\nMultiplication of whole numbers: %v\n", mediums.MultiplyGeneric(wholeNumbers))
	fmt.Println(divider)
}
