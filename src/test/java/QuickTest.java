import org.junit.*;

public class QuickTest {

    static StringHelper helper;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("After class");
    }

    @Before
    public void setUp() {
        helper = new StringHelper();
        System.out.println("Before Test");
    }

    @After
    public void tearDown() {
        System.out.println("After Test");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

}
