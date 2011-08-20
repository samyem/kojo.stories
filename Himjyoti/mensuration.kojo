val pageStyle = "color:#f0f0f0; margin:15px;background:green;"

val pg=Page(
    name = "",
    body =
        <body style={pageStyle}> 
            <br></br> <br></br> <h1> Welcome to kojo learning <br></br>environment.</h1>  
            <br></br> <br></br> <strong>Topic : Mensuration </strong>
        </body>,
    code = {
        val score = MusicScore(
            Melody("Flute", "C E A D A4 C F E"),
            Melody("Pan_flute", "C E A D A4 C F E"),
            Rhythm("Hand_clap", "q", ".o.o.o.o")
       )
        playMusic(score)        
    }
)
val pg1= Page(
    name = "",
    body =
        <body style={pageStyle}> 
            What is Geometry?<br/><br/>
            <em>Geo</em> means Earth. <em>Metry</em> means measurement. Geometry was 
            created to measure shapes on land (e.g to meaure the area of a rectangular field).<br/><br/>
            Mensuration is a topic in Geometry that deals directly which the process 
            of <strong>measurement</strong>.<br></br> <strong>Mensuration</strong> is 
            based on the use of <strong >algebric equestions</strong> and <strong>geometric 
                calculations </strong>to provide measurement data regarding the width, depth 
            and volume of a given object or a group of objects.<br/><br/>
            This story investigates the relationship between perimeter and area 
            for rectangular shapes.
        </body>,
    code = {}
)
val pg2=Page(
    name = "",
    body =
        <body style={pageStyle}> 
            Let's investigate rectangles with a perimeter of, say, 400m. 
            Based on this perimeter, let us look at the area of a few different
            rectangles.<br/><br/>
            
            The buttons at the bottom of this page allow you to create four
            different rectangles with a perimeter of 400m. Click on the buttons
            to create the different rectangles.<br/><br/>
            
            [1]First rectangle is 
            of 170m*30m and area is 5100m².<br></br><br></br>
            [2]Second
            rectangle is of 150m*50m and area 7500m².<br></br><br></br>
            [3]Third
            rectangle is of 140m*60m and area is 8400m²<br></br><br></br>
            [4]Fourth rectangle is of 110m*90m and area is 9900m². 
        </body>,
    code = {
        clear()
        invisible()
        stAddButton ("R1") {
            val l1 = 170
            val b1 = 30
            setPosition(-200, 100)
            setFillColor(green)
            repeat (2) {
                forward(b1)
                right()
                forward(l1)
                right()
            }
            write("Area (m²): " + l1 * b1)
        }

        stAddButton ("R2") {
            val l2 = 150
            val b2 = 50

            setPosition(75, 100)
            setFillColor(blue)
            repeat (2) {
                forward(b2)
                right()
                forward(l2)
                right()
            }
            write("Area (m²): " + l2 * b2)
        }
  
        stAddButton ("R3") {
            val l3 = 140
            val b3 = 60

            setPosition(-215, -101)
            setFillColor(yellow)
            repeat (2) {
                forward(b3)
                right()
                forward(l3)
                right()
            }
            write("Area (m²): " + l3 * b3)
        }  
        stAddButton ("R4") {
            val l4 = 110
            val b4 = 90

            setPosition(81, -101)
            setFillColor(purple)
            repeat (2) {
                forward(b4)
                right()
                forward(l4)
                right()
            }
            write("Area (m²): " + l4 * b4)
        }  
    }                      )
val pg3=Page(
    name = "",
    body =
        <body style={pageStyle}> 
            Do you see a pattern here? How does the area change as the length of the rectangle increases?<br></br>
            As the length of the rectangle increases, the area decreases.<br/><br/>
            
            What is the rectangle (with a given perimeter) with the smallest possible length?<br/><br/>
            It's a square.<br/><br/>
            So, amongst all possible rectangles with a given perimeter, the square has the biggest area.
        </body>,
    code = {}
)
val pg4=Page(
    name = "",
    body =
        <body style={pageStyle}> 
            Let's look at a possible application of this result in our daily life <br/><br/>
            
            Suppose you want to build a hall having a perimeter of 800m and    
            covering the maximum possible area. What will the dimensions of the 
            hall be? <br/><br/>
            You can answer the question by filling in the fields below. See if you
            can get it right!
            
        </body>,
    code = {
        stAddField("length", "")
        stAddField("width", "")
        stAddButton ("Make Hall") {
            clear()
            val length = stFieldValue("length", 100)
            val width = stFieldValue("width", 80)
            setPenColor(black)
            setFillColor(red)   
            repeat (2) {
                forward(width)
                right()
                forward(length)
                right() 
            }
            if (length != 200 || width != length) {
                stShowStatusError("You got that wrong!")
            }
            else {
                stShowStatusMsg("You are right. Congratulations!")
            }
        }
    }
)
val story = Story(pg,pg1,pg2,pg3,pg4)
stClear()
stPlayStory(story) 
