// https://www.hackerrank.com/challenges/strange-advertising
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
	days := int(readInt())
	ads := 5
	likes := ads / 2
	for i := 1; i < days; i++ {
		ads = 3 * (ads / 2)
		likes += ads / 2
	}
	fmt.Println(likes)
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
