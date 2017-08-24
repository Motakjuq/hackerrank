// https://www.hackerrank.com/challenges/the-hurdle-race
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

func main() {
	initIO()
	values := int(readInt())
	jump := int(readInt())
	max := 0
	drink := 0
	for i := 0; i < values; i++ {
		v := int(readInt())
		if v > max {
			max = v
			if jump < max {
				drink = max - jump
			}
		}
	}
	fmt.Println(drink)
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
