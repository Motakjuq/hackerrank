// https://www.hackerrank.com/challenges/migratory-birds
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
	var list [5]int
	v := int(readInt()) - 1
	list[v]++
	common := v
	for i := 1; i < values; i++ {
		v = int(readInt()) - 1
		list[v]++
		if list[common] <= list[v] && common != v {
			if (v < common && list[common] == list[v]) || list[common] < list[v] {
				common = v
			}
		}
	}
	fmt.Println(common + 1)
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
