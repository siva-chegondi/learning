package basics

import "fmt"

/**
* Types
* method to cast different data types
 */
func Types() {

	var i8 int8 = 124
	var i64 int64 = int64(i8)

	fmt.Println("Casting from int8 to int64 --> int64(i8) =", i64)

	var i16 int16 = int16(i64)
	fmt.Println("Casting from int64 to int16 --> int16(i64) =", i16)

	var ui64 uint = uint(i16)
	fmt.Println("Casting from int16 to uint --> uint(i16) =", ui64)
}

/**
* Pointers
* method to work with pointers
 */
func Pointers() {

	var i8 int8 = 97
	var p = &i8
	fmt.Println("Pointer of i8: ", p)
	fmt.Printf("Type and Value of p: %T %v\n", p, *p)
}
