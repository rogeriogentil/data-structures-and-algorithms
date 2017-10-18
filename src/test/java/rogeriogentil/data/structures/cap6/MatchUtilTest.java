package rogeriogentil.data.structures.cap6;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author rogerio
 */
public class MatchUtilTest {

   @Test
   public void deveValidarQuandoNaoHaCaracteresDeAberturaOuFechamento() {
      String expressao = "1 + 1 - 2";
      boolean isMatched = MatchUtil.isMatched(expressao);

      assertThat(isMatched, is(true));
   }

   @Test
   public void deveValidarComExpressaoSimples() {
      String expressao = "(1 + 1 - 2)";
      boolean isMatched = MatchUtil.isMatched(expressao);

      assertThat(isMatched, is(true));
   }
   
   @Test
   public void deveValidarComExpressaoComposta() {
      String expressao = "[1 + (1 - 2)]";
      boolean isMatched = MatchUtil.isMatched(expressao);

      assertThat(isMatched, is(true));
   }
   
   @Test
   public void naoDeveValidarExpressaoSimple() {
      String expressao = "(1 + 1 - 2";
      boolean isMatched = MatchUtil.isMatched(expressao);

      assertThat(isMatched, is(false));
   }
}
