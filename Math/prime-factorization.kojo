// start num lib
// cut-n-paste till we have support (soon!) for require(filename)

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

// end num lib

var Siz = 40.0
val FontSize = 20

def rect(w: Double, h: Double) {
    forward(h); right()
    forward(w); right()
    forward(h); right()
    forward(w); right()
}

def square(n: Double) {
    rect(n, n)
}

def showNumberHelper(n: Int)(borderMaker: => Unit) {
    borderMaker
    
    val ts = textExtent(n.toString, FontSize)
    
    penUp()
    forward(ts.height + (Siz - ts.height)/2)
    right()
    forward((Siz - ts.width)/2)
    penDown()
    
    saveStyle()
    setPenColor(blue)
    write(n.toString)
    restoreStyle()

    penUp()
    back((Siz - ts.width)/2)
    left()
    back(ts.height + (Siz - ts.height)/2)
    penDown()
}

def showNumberInBox(n: Int) {
    showNumberHelper(n) {
        square(Siz)
    } 
}

def showNumberInL(n: Int) {
    showNumberHelper(n) {
        forward(Siz)
        back(Siz)
        right()
        forward(Siz)
        back(Siz)
        left()
    } 
}

def showNumber(n: Int) {
    showNumberHelper(n) {}
}

def showFactorTree(f: (Int, Int)) {
    val (f1, f2) = (f._1, f._2)
    
    // left leg
    left(135)
    forward(Siz)
    
    // goto box starting position
    penUp()
    forward(math.sqrt(Siz * Siz * 2))
    right(135)
    penDown()

    // make tree for the first factor
    factorTree(f1)
    
    // back to starting point
    penUp()
    right(45)
    forward(math.sqrt(Siz * Siz * 2) + Siz)
    left(45)
    penDown()

    // right leg
    right(135)
    forward(Siz)

    // goto box starting position
    penUp()
    right(45)
    forward(Siz)
    right(180)
    penDown()

    // make tree for the second factor
    factorTree(f2)

    // go back to the starting point
    // this is not strictly necessary for this command because
    // (a) the factorTree call above is the last thing that this 
    // command does, and
    // (b) the ealier factorTree call does not recurse (because 
    // f1 is always a prime)
    // be we go back to the starting point anyway - in keeping
    // with the convention that a command leaves the turtle 
    // where it picked it up from
    penUp()
    forward(Siz)
    left(45)
    forward(Siz)
    right(45)
    penDown()
}

def factorTree(n: Int) {
    if (isPrime(n)) {
        showNumberInBox(n)
    }
    else {
        showNumberInBox(n)
        showFactorTree(twoFactors(n))
    }
}

def showLeftNumber(n: Int) {
    penUp()
    left()
    forward(Siz)
    right()
    penDown()
    
    showNumber(n)
    
    penUp()
    right()
    forward(Siz)
    left()
    penDown()
}

def moveDown() {
    penUp()
    right(180)
    forward(Siz)
    left(180)
    penDown()
}

def showFactorStairs(f: (Int, Int)) {
    val (f1, f2) = (f._1, f._2)
    
    showLeftNumber(f1)
    moveDown()
    
    cdiv(f2)
    
    penUp()
    forward(Siz)
    penDown()
}

def cdiv(n: Int) {
    if (isPrime(n)) {
        showNumberInL(n)
        showLeftNumber(n)
        moveDown()
        showNumberInL(1)
        forward(Siz)
    }
    else {
        showNumberInL(n)
        showFactorStairs(twoFactors(n))
    }
}

def title(s: String) {
    val ts = textExtent(s, FontSize)
    penUp()
    forward(100)
    left()
    forward(ts.width/2)
    penDown()
    
    saveStyle()
    setPenColor(blue)
    setPenThickness(4)
    write(s)
    restoreStyle()
    
    penUp()
    back(ts.width/2)
    right()
    back(100)
    penDown()
}


val pageStyle = "color:white;background:#016491;margin:15px;"
val headerStyle = "text-align:center;font-size:110%;color:yellow;"

def pgHeader(hdr: String) =
    <p style={headerStyle}>
        {xml.Unparsed(hdr)}
        <hr/>
    </p>


val pg = Page(
    name = "",
    body = 
        <body style={pageStyle}>
            {pgHeader("Visualizing Prime Factorization")}
            <p>
                Wanna see how you can factorize any number and come
                up with its prime factorization?
            </p>
            
            <p>
                Enter a number below and click <em>Factorize</em>
            </p>
            
        </body>,
    code = {
        clear()
        clearOutput()
        stAddField("Number", 12)
        stAddButton ("Factorize") {
            val n = stFieldValue("Number", 12)
            val ts = textExtent(n.toString, FontSize)
            Siz = if (ts.width > Siz) ts.width + 10 else Siz
            clear()
// invisible()
            setAnimationDelay(100)
            setPenFontSize(FontSize)

            penUp()
            forward(100)
            left()
            forward(Siz * 6)
            right()
            penDown()
            
            title("Factor Tree Method")
            factorTree(n)

            penUp()
            right()
            forward(Siz * 12)
            left()
            penDown()

            title("Continuous Division Method")
            cdiv(n)
            
            penUp()
            home()
            forward(150)
            penDown()
            title("%d = %s" format(n, primeFactors(n).mkString(" x ")))
            left(45)
        }
    }
)

val story = Story(pg)
stClear()
stPlayStory(story)
