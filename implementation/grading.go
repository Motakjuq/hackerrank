// https://www.hackerrank.com/challenges/grading/problem
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
    cases := readInt()
    for i := 0 ; i < cases ; i++ {
        grade := readInt()
        if grade < 38 {
            fmt.Println(grade)
        } else if grade % 5 >= 3 {
            fmt.Println(5 * (grade / 5 + 1))
        } else {
            fmt.Println(grade)
        }
    }
}

func initIO(){
    reader = bufio.NewReader(os.Stdin)
    buffer = &bytes.Buffer{}
    buffer.Grow(64)
}

func isSpace(b byte) bool {
    return ' ' == b || '\n' == b
}

func readInt() int {
    for c,err := reader.ReadByte(); !isSpace(c) && err == nil ; c,err = reader.ReadByte() {
        buffer.WriteByte(c)
    }
    val, _ := strconv.ParseInt(buffer.String(),10, 64)
    buffer.Reset()
    return int(val)
}
