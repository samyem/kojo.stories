val pageStyle = "color:#fofo; margin:15px;background:yellow;"

val pg1 = Page(
    name = "",
    body =
        <body style={pageStyle}> 
            <strong>  The Angle Sum Property of Triangles</strong >
            <br/><br/>
            The Angle Sum Property of Triangles states that the sum of  triangle's  angle is 180° 
            <br/><br/>
            Let's look at a proof of that property...
        </body>,
    code = { 
        val score = MusicScore(
            Melody("Guitar", "C6q D#6q F6q G6q D#6q F6h Rq D#6q F6q G6q F6q C6q D#6h Rq"),
            Melody("Pan_flute", "C6q D#6q F6q G6q D#6q F6h Rq D#6q F6q G6q F6q C6q D#6h Rq"),
            Rhythm("Acoustic_Bass_Drum", "q", "o.o.o.o.o.o.o.o.")
        )

        playMusic(score)
    }    
) 

val pg2 = Page(
    name = "",
    body =
        <body style={pageStyle}> 
            The figure to the right shows two parallel lines L1 and L2, 
            that are cut by a transversal L3.
            <br/>
            A corollary to Euclid's fifth postulate states that, for two parallel
            lines that are cut by a transversal, the sum of the
            interior angles on the same side of the transversal is 180°.<br/><br/>
            
            From this, it is easy to show that, for two parallel
            lines that are cut by a transversal, alternate angles are equal.<br/><br/>
            
            Play with the figure on the right to get a better feel for the 
            truth of this statement.
            
           
        </body>,
    code = {
        Mw.clear()
        Mw.hideAxes()
        Mw.hideAlgebraView()
        val fig = Mw.figure("F1")

        // Make first line
        val P1 = Mw.point(-10, 3)
        val P2 = Mw.point(20, 3)
        val L1 = Mw.line(P1,P2)
        L1.setLabel("L1")
        fig.add(L1)

        // Make second line, parallel to first
        val P3 = Mw.point(-10, 1)
        val P4 = Mw.point(20, 1)
        val L2 = Mw.line(P3, P4)
        L2.setLabel("L2")
        fig.add(L2)

        // Make transversal
        val P5 = Mw.point(1, 0)
        P5.setLabel("P5")
        fig.add(P5)
        val P6 = Mw.point(4, 4)
        P6.setLabel("P6")
        fig.add(P6)
        val L3 = Mw.line(P5, P6)
        L3.setLabel("L3")
        fig.add(L3)

        // Find intersection points of transversal with lines
        val P7 = Mw.intersect(L1, L3)
        val P8 = Mw.intersect(L2, L3)

        // Show Angles that transversal makes with lines
        val color1 = color(0, 102, 0)

        val A1 = Mw.angle(P1,P7,P5)
        A1.setColor(color1)
        A1.setLabel("A1")
        fig.add(A1)

        val A3 = Mw.angle(P4,P8,P6)
        A3.setColor(color1)
        A3.setLabel("A3")
        fig.add(A3)

        fig.show()
    }
)

val pg3 = Page(
    name = "",
    body =
        <body style={pageStyle}> 
            We know that the sum  of interior angles of a triangle is 180°.
            But how can we prove that?<br/><br/>
            
            Once we know that, for two parallel
            lines that are cut by a transversal, the alternate angles are equal - it
            is easy to prove the angle sum property of triangles.<br/><br/>
            
            Take a look at the figure to the right? Can you see why the 
            sum of the angles of a triangle is 180°?
        </body>,
    code = {
        Mw.clear()
        Mw.hideAxes()
        val fig = Mw.figure("F1")

        // Make first line
        val P1 = Mw.point(-10,3)
        val P2 = Mw.point(20,3)
        val L1 = Mw.line(P1,P2)

        // Make second line, parallel to first
        val P3 = Mw.point(-10,1)
        val P4 = Mw.point(20,1)
        val L2 = Mw.line(P3,P4)
        fig.add(L1, L2)

        // Make Triangle

        // Make first vertex on the first line
        val A = Mw.pointOn(L1, 2, 3)

        // Make other two vertices on the second line
        val B = Mw.pointOn(L2, 1, 1)
        val C = Mw.pointOn(L2, 4, 1)
        fig.add(A, B, C)

        val c = Mw.lineSegment(A,B)
        val a = Mw.lineSegment(B,C)
        val b = Mw.lineSegment(C,A)
        fig.add(a, b, c)

        val color1 = color(0, 0, 102)
        val color2 = color(153, 0, 0)

        val X = Mw.angle(B,A,C)
        X.setLabel("X")
        X.showNameInLabel()
        val Y = Mw.angle(C,B,A)
        Y.setColor(color1)
        Y.setLabel("Y")
        Y.showNameInLabel()
        val Z = Mw.angle(A,C,B)
        Z.setColor(color2)
        Z.setLabel("Z")
        Z.showNameInLabel()
        fig.add(X, Y, Z)

        val Yp = Mw.angle(P1,A,B)
        Yp.setColor(color1)
        Yp.setLabel("Y'")
        Yp.showNameInLabel()
        val Zp = Mw.angle(C,A,P2)
        Zp.setColor(color2)
        Zp.setLabel("Z'")
        Zp.showNameInLabel()
        fig.add(Yp, Zp)

        fig.show()
        
    }
)
val pg4 = Page(
    name = "",
    body =
        <body style={pageStyle}> 
            Is the sum of the angles of a triangle always equal to 180°?<br/><br/>
            
            Our proof of this fact was based on Euclid's fifth postulate. But what 
            about situations where this postulate is not true? <br/><br/>
            
            In such cases, the angle sum property does not hold. Geometries of 
            this nature are called Non-Euclidean Geometries. <br/><br/>
            
            Can we think of one such situation?<br/><br/>
            <img src="Picture4.jpg"/>
            <br/>
            The surface of a sphere presents such a situation. 
            If we make a triangle on the surface of a sphere and add up its three angles, we'll
            find that the sum of the angles is not 180°!
        </body>,
    code = {}
)
val pg5= Page(
    name = "",
    body =
        <body style={pageStyle}> 
            <strong>TRY THIS </strong ><br/> <br/>
            <em> ACTIVITY FOR YOU <br/> <br/>
                FOR YOUR EXPERIMENT   </em>
            <img src="Picture2.png"/>
        </body>,
    code = {}
)
val pg6 = Page(
    name = "",
    body =
        <body style={pageStyle}> 
            <strong> BRAIN STORMING</strong>           <br/>   <br/>
            <img src="Picture1.jpg"/>
            Suppose you have a large field. How can you determine whether the 
            field is curved or flat?<br/><br/><br/> 
            
            
            Put three pegs into the field in the shape of a triangle and 
            tie a rope around them. Measure all  three angles of the triangle.
            If the field is flat, the sum will be around 180° (because
            we can not actually measure with great accuracy). If 
            the field is (convex) curved, then the sum  will be  more than 180°.
        </body> ,
    code = {}
)
val story = Story (pg1, pg2, pg3,pg4, pg5 ,pg6) 
stClear()
stPlayStory(story)