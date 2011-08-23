def isPrime(n: Int): Boolean = {
    if (n == 1) return false
    
    for (i <- 2 to n/2) {
        if (n %i == 0) {
            return false
        }
    }
    return true
}

// don't call for prime numbers
def twoFactors(n: Int): (Int, Int) = {
    for (i <- 2 to n/2) {
        if (n % i == 0) {
            return (i, n / i)
        }
    }
    throw new IllegalStateException("Problemo - twoFactors()!")
}

def primeFactors(n: Int): List[Int] = {
    if (isPrime(n)) {
        List(n)
    }
    else {
        val tf = twoFactors(n)
        tf._1 :: primeFactors(tf._2)
    }
}

val primes = List(2,3,5,7,11,13,17,19)

// Tests

clearOutput()

// isPrime tests
test("prime1") {
    isPrime(1) should be(false)
}

test("prime2") {
    isPrime(2) should be(true)
}

test("prime3") {
    isPrime(3) should be(true)
}

test("prime4") {
    isPrime(4) should be(false)
}

test("prime21") {
    isPrime(21) should be(false)
}

test("prime47") {
    isPrime(47) should be(true)
}

test("prime49") {
    isPrime(49) should be(false)
}

// twoFactors tests

test("twoFactors 6") {
    twoFactors(6) should be(2,3)
}

// primeFactors tests

test("primeFactors 6") {
    primeFactors(6) should be(List(2,3))
}

test("primeFactors 12") {
    primeFactors(12) should be(List(2,2,3))
}

test("primeFactors 66") {
    primeFactors(66) should be(List(2,3,11))
}

