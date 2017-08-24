// https://www.hackerrank.com/challenges/sock-merchant
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
	l := make([]int, 100)
	count := 0
	for i := 0; i < values; i++ {
		v := int(readInt()) - 1
		l[v]++
		if l[v]%2 == 0 {
			count++
		}
	}
	fmt.Println(count)
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
