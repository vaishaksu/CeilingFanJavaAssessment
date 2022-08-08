package mavenproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CeilingTest {
    
    CeilingFan ceilingFan;

    @BeforeEach
	void setUp() throws Exception {
		ceilingFan = new CeilingFan();
	}

    @Test
    void testRotateForwardDirectionBySpeedingUp() {
		assertEquals(Direction.FORWARD, ceilingFan.getDirection()); // Getting the direction to Forward
		assertEquals(ceilingFan.TurnOff, ceilingFan.getRotateSpeed()); // Always off

		ceilingFan.speedUp();
		assertEquals(1, ceilingFan.getRotateSpeed());
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());
		System.out.println(ceilingFan.toString());

		ceilingFan.speedUp();
		assertEquals(2, ceilingFan.getRotateSpeed());
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());

		ceilingFan.speedUp();
		assertEquals(3, ceilingFan.getRotateSpeed());
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());

		ceilingFan.speedUp();
		assertEquals(ceilingFan.TurnOff, ceilingFan.getRotateSpeed());
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());

        System.out.println(ceilingFan);
    }

	@Test
	void testRotateOppositeDirection() {
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());
		assertEquals(ceilingFan.TurnOff, ceilingFan.getRotateSpeed());

		ceilingFan.reverseDirection();
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());
		assertEquals(ceilingFan.TurnOff, ceilingFan.getRotateSpeed());

		ceilingFan.speedUp();
		assertEquals(1, ceilingFan.getRotateSpeed());
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());

		ceilingFan.speedUp();
		assertEquals(2, ceilingFan.getRotateSpeed());
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());

		ceilingFan.speedUp();
		assertEquals(3, ceilingFan.getRotateSpeed());
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());

		ceilingFan.speedUp();
		assertEquals(ceilingFan.TurnOff, ceilingFan.getRotateSpeed());
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());
	}

    @Test
	void testFowardReverseSpeedingUpFanDirection() {
		assertEquals(ceilingFan.TurnOff, ceilingFan.getRotateSpeed());
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());

		ceilingFan.reverseDirection();
		assertEquals(ceilingFan.TurnOff, ceilingFan.getRotateSpeed());
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());

		ceilingFan.speedUp();
		assertEquals(1, ceilingFan.getRotateSpeed());
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());

		ceilingFan.reverseDirection();
		assertEquals(1, ceilingFan.getRotateSpeed());
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());

		ceilingFan.speedUp();
		assertEquals(2, ceilingFan.getRotateSpeed());
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());

		ceilingFan.reverseDirection();
		assertEquals(2, ceilingFan.getRotateSpeed());
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());

		ceilingFan.speedUp();
		assertEquals(3, ceilingFan.getRotateSpeed());
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());

		ceilingFan.reverseDirection();
		assertEquals(3, ceilingFan.getRotateSpeed());
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());

		ceilingFan.speedUp();
		assertEquals(ceilingFan.TurnOff, ceilingFan.getRotateSpeed());
		assertEquals(Direction.FORWARD, ceilingFan.getDirection());

		ceilingFan.reverseDirection();
		assertEquals(ceilingFan.TurnOff, ceilingFan.getRotateSpeed());
		assertEquals(Direction.BACKWARD, ceilingFan.getDirection());

	}

}
