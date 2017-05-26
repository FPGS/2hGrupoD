import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.hamcrest.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BTest {

	A object = new A();

	@Test(expected = IOException.class)
	public void OutputStreamWriter_rethrows_an_exception_from_OutputStream() throws IOException {
		OutputStream mock = Mockito.mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		Mockito.doThrow(new IOException()).when(mock).close();
		osw.close();
	}

	@Test
	public void OutputStreamWriter_Buffers_And_Forwards_To_OutputStream() throws IOException {
		OutputStream mock = Mockito.mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		osw.write('a');
		osw.flush();
		// can't do this as we don't know how long the array is going to be
		// verify(mock).write(new byte[]{'a'},0,1);

		ArgumentMatcher<byte[]> arrayStartingWithA = new ArgumentMatcher<byte[]>() {

			public void describeTo(Description arg0) {

			}

			public boolean matches(byte[] argument) {
				byte[] actual = argument;
				return actual[0] == 'a';
			}
		};

		// check that first character of the array is A,
		// and that the other two arguments are 0 and 1
		Mockito.verify(mock).write(Mockito.argThat(arrayStartingWithA), Mockito.eq(0), Mockito.eq(1));
	}

}
