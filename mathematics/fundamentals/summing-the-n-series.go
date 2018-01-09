// https://www.hackerrank.com/challenges/summing-the-n-series/problem
package main

import (
    "fmt"
    "os"
    "bufio"
    "strconv"
    "bytes"
    "math"
    "math/big"
)

var (
    reader *bufio.Reader
    buffer *bytes.Buffer
)

func main() {
    initIO()
    cases := int(readInt())
    div := int64(math.Pow10(9)) + 7
    aux_mod := big.NewInt(div)
    exp := big.NewInt(2)
    r := new(big.Int)
    for i := 0 ; i < cases ; i++ {
        n := big.NewInt(readInt())
        r.Exp(n, exp, aux_mod)
        fmt.Println( r )
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

func readInt() int64 {
    for c,err := reader.ReadByte(); !isSpace(c) && err == nil ; c,err = reader.ReadByte() {
        buffer.WriteByte(c)
    }
    val, _ := strconv.ParseInt(buffer.String(),10, 64)
    buffer.Reset()
    return int64(val)
}

