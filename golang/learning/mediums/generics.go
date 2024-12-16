package mediums

// Generics

/**
* In golang, generic functions are helpful to
* write methods for different types supporting
* same action.
*
* Generic functions takes type parameters along
* with method arguments
*
* @syntax: func name[type parameters](arguments) (return types)
 */

// SumGeneric generic function to add given array
func SumGeneric[V int64 | int32 | float64](data []V) V {
	var value V = 0
	for _, v := range data {
		value += v
	}
	return value
}

/**
* Type parameters can be union of multiple types
* @syntax: int64 | float64 | int32
*
* You can also declare a type constraint for
* union of multiple types
 */

// Number interface to hold type constraint
type Number interface {
	int64 | float64 | int32
}

// MultiplyGeneric function to multiply
// all given array elements
func MultiplyGeneric[T Number](data []T) T {
	var value T
	for _, v := range data {
		value *= v
	}
	return value
}
