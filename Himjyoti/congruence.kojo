val pageStyle = "color:#f0f0f0; margin:15px;background:#1e6d28;"

val pg1 =Page(
    name = "",
    body =
        <body style={pageStyle}>
            <br/><br/><br/><br/><strong>Congruence of Triangles</strong>
            <br/><br/><br/><br/><strong>Subject : Maths</strong>
            <br/><br/>This story is written to tell you about congruence.
        </body>,
    code = {
        val score = MusicScore(
            Melody("flute", "C6q D#6q F6q G6q D#6q F6h Rq D#6q F6q G6q F6q C6q D#6h Rq"),
            Rhythm("Hand_Clap", "q", "o.o.o.o.o.o.o.o.")
        )

        playMusic(score)        
    }
)

val pg2 =Page(
    name = "",
    body =
        <body style={pageStyle}>
            <br/><strong>Congruence</strong>
            <br/><br/><br/> What is a  congruence?
            <br/>Two shapes are congruent if all
            sides and angles in one, are equal
            to the sides and angles in the 
            other.<br/> 
            <br/> Take  two  stamps which covers  the  other  stamp compeletly  
            and exactly.This  means that the two  stamps  are  of  the  same  shape 
            and  same  size. Such  objects  are  said  to  be congruent.
        </body>,
    code = { 
        stAddButton ("See example of congruence ") {
            clear()
            setAnimationDelay(100)
            invisible()
            repeat (4){forward(100)
                       right(90)
            }                         
            right(90)
            penUp()
            forward(150)
            penDown()
            left(90)
            repeat (4){forward(100)
                       right(90)
            } 
            turn(120)
        }
    }
)

val pg3=Page(
    name = "",
    body =
        <body style={pageStyle}>
            <strong>Conguerence of triangles</strong>
            <br/><br/> Congruent triangles are of particular importance in 
            mathematics because they enable us to determine/prove many 
            geometrical properties/theorems. <br/><br/>
            Let's investigate one criterion (SAS) for congruence in detail...
            
        </body>,
    code = {stAddButton ("See example of congruent triangles") {
            clear()
            setAnimationDelay(100)
            invisible()
            right(90)
            forward(100)
            left(120)       
            forward(100)
            left(120)
            forward(100)
            left(120)
            penUp()
            forward(150)
            penDown()
            forward(100)
            left(120)       
            forward(100)
            left(120)
            forward(100)
            left(120)
        }
            
    }
)

val pg4 =Page(
    name = "",
    body =
        <body style={pageStyle}>
            Before we discuss that criterion, let us investigate what it means for a criterion of 
            congruence to be valid.<br/><br/>
            Do you think that AAA is a valid criterion for congruence?<br/><br/>
            One good way to check is by seeing if we can make two different triangles 
            using this criterion. If we can, then the criterion is obviously invalid.
            Click on the Check AAA button below to play with this idea.
        </body>,
    code = {
        stAddButton ("Check AAA") {
            Mw.clear()
            Mw.hideAlgebraView()
            Mw.hideAxes()
            Mw.hideGrid()
            val a = Mw.point(0, 0, "A")
            val b = Mw.point(0, 2, "B")
            val c = Mw.point(2, 0, "C")
            val ab = Mw.lineSegment(a, b)
            val bc = Mw.lineSegment(b, c)
            val ca = Mw.lineSegment(c, a)

            val d = Mw.point(3, 0, "A'")
            val e = Mw.point(3, 4, "B'")
            val f = Mw.point(7, 0, "C'")
            val de = Mw.lineSegment(d, e)
            val ef = Mw.lineSegment(e, f)
            val fd = Mw.lineSegment(f, d)

            Mw.show(a,b,c,d,e,f,ab,bc,ca,de,ef,fd)
        }
    }
)

val pg5 =Page(
    name = "",
    body =
        <body style={pageStyle}>
            <br/><br/>We see that we can make two different triangles with the 
            same AAA. So AAA is not a valid criterion for congruence.<br/><br/>
            
            If we can make only one triangle using a potential criterion for congruence,
            then that will be a valid criterion.
        </body>
) 

val pg6 = Page(
    name = "",
    body =
        <body style={pageStyle}>
            <strong>The SAS(side angle side) Criterion</strong>
            <br/><br/>If under a given correspondence, two sides and the included angle of one triangle
            are equal to the corresponding two sides and included angle of another triangle,
            then the triangles are congruent. <br/><br/>
            Let's see how many different triangles we can make with the SAS criterion.
        </body>,
    code = {stAddButton ("SAS") {
            clear()
            setAnimationDelay(100)
            invisible()
            setPenColor(purple)
            setPenThickness(6)
            forward(150)
            turn(-75)
            forward(100) 
            home
                   
            setPenColor(green)
            setPenThickness(3)
            forward(150)
            turn(-95)
            forward(100)
            home}}
    
)

val pg7 =Page(
    name = "",
    body =
        <body style={pageStyle}>
            <strong>Example for better understanding</strong>
            Example: <br/><br/>There is a rectanguler door and Sita is not sure
            whether the door is perfectly rectangular (i.e all the corners are
            right angled, and the opposite sides are equal).<br/><br/>
            
            Sita can make use of the SAS criterion to make sure that the door
            is perfectly rectangular. Given that triangles ABC and DCB are congruent
            as per the SAS criterion, the diagonals AC and BD should be equal. Sita
            can measure the diagonals, and if they are equal, she can be sure that
            the door is perfectly rectangular.
            <br/>
            <br/>
            To be continued...
        </body>,
    code = {stAddButton ("Sample of door") { 
            clear()
            setAnimationDelay(100)
            invisible()
            repeat (2) { 
                forward(250)
                right(90)
                forward(150)
                right(90)
                    
            }
            
            setPenColor(blue)
            right(30.7)
            forward(290)
            right(-120)
            penUp()
            forward(150)
            penDown()
            right(-121.5)
            forward(295)
            right(120)
            penUp()
            forward(160)
            penDown()
            write("B")
            penUp()
            right(90)
            forward(260)
            penDown()
            write("A")
            penUp()
            right(90)
            forward(170)
            penDown()
            write("D")
            penUp()
            right(90)
            forward(260)
            penDown()
            write("C")
        }
    }
)


val story = Story(pg1,pg2,pg3,pg4,pg5, pg6,pg7)

stClear()
stPlayStory (story)
              