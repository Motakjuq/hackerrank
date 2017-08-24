// https://www.hackerrank.com/challenges/cats-and-a-mouse
package main

import (
	"bufio"
	"bytes"
	"fmt"
	"os"
	"strconv"
)

var (
	reader *bufio.Reader
	buffer *bytes.Buffer
)

func subAbs(x, y int) int {
	if x > y {
		return x - y
	}
	return y - x
}

func main() {
	initIO()
	values := int(readInt())
	for i := 0; i < values; i++ {
		c1 := int(readInt())
		c2 := int(readInt())
		m := int(readInt())
		d1 := subAbs(c1, m)
		d2 := subAbs(c2, m)
		if d1 == d2 {
			fmt.Println("Mouse C")
		} else if d1 > d2 {
			fmt.Println("Cat B")
		} else {
			fmt.Println("Cat A")
		}
	}
}

func initIO() {
	reader = bufio.NewReader(os.Stdin)
	buffer = &bytes.Buffer{}
	buffer.Grow(64)
}

func isSpace(b byte) bool {
	return ' ' == b || '\n' == b
}

func readInt() int64 {
	for c, err := reader.ReadByte(); !isSpace(c) && err == nil; c, err = reader.ReadByte() {
		buffer.WriteByte(c)
	}
	val, _ := strconv.ParseInt(buffer.String(), 10, 64)
	buffer.Reset()
	return val
}
