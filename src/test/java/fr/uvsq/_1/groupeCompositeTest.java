package fr.uvsq._1;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import fr.uvsq._1.Personnel.builder;

public class groupeCompositeTest 
{
	public void addTest()
	{
		GroupeComposite g = new GroupeComposite();
		GroupeComposite g2 = new GroupeComposite();

		builder b = new builder("bow","ser",LocalDate.of(1, 1, 1));
		Personnel p = b.build();
		g.add(p);
		g.add(g2);
		assertEquals(g.getL().get(0),p);
	} 
	
	public void lecture_compositeTest()
	{
		GroupeComposite g = new GroupeComposite();  
		GroupeComposite g2 = new GroupeComposite();

		builder b = new builder("bow","ser",LocalDate.of(1, 1, 1));
		Personnel p = b.build();
		builder b2 = new builder("ma","rio",LocalDate.of(1, 1, 1));
		Personnel p2 = b2.build();
		g.add(p);
		g.add(g2);
		g2.add(p2);
		g.affiche(0);
	}
}
