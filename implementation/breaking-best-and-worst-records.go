// https://www.hackerrank.com/challenges/breaking-best-and-worst-records
package main

import (
    "fmt"
    "os"
    "bufio"
    "strconv"
    "bytes"
)

var (
    reader *bufio.Reader
    buffer *bytes.Buffer
)

func main() {
    initIO()
    values := int(readInt())
    max := readInt()
    min := max
    maxCount := 0
    minCount := 0
    for i := 1 ; i < values ; i++ {
        v := readInt()
        if v > max {
            max = v
            maxCount++
        }else if v < min {
            min = v
            minCount++
        }
    }
    fmt.Println(maxCount, minCount)
}

func initIO(){
    reader = bufio.NewReader(os.Stdin)
    buffer = &bytes.Buffer{}
    buffer.Grow(64)
}

func isSpace(b byte) bool {
    return ' ' == b || '\n' == b
}

func readInt() int64 {
    for c,err := reader.ReadByte(); !isSpace(c) && err == nil ; c,err = reader.ReadByte() {
        buffer.WriteByte(c)
    }
    val, _ := strconv.ParseInt(buffer.String(),10, 64)
    buffer.Reset()
    return val
}
