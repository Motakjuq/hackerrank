// https://www.hackerrank.com/challenges/equality-in-a-array
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
	var l [100]int
	repeated := 1
	l[int(readInt())-1]++
	for i := 1; i < values; i++ {
		v := int(readInt()) - 1
		l[v]++
		if repeated < l[v] {
			repeated = l[v]
		}
	}
	fmt.Println(values - repeated)
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
