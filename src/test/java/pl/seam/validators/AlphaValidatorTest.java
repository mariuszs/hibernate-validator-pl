package pl.seam.validators;

import org.hibernate.validator.ClassValidator;
import org.junit.Test;
import pl.seam.validators.helpers.HumanBeing;
import pl.seam.validators.helpers.ValidatorTestHelper;

/**
 * User: <a href="http://javaunderhood.wordpress.com">Maciej Kreft</a>
 */
public class AlphaValidatorTest {

    @Test
    public void alpha_allow_only_alpha_by_default(){
        HumanBeing hb = new HumanBeing("OnlyAlphaHereĄęłżźćłóś");
        ClassValidator<HumanBeing> cv = new ClassValidator<HumanBeing>(HumanBeing.class);
        ValidatorTestHelper.assertTrueOrShowErrors(hb, cv, true);
    }
    @Test
    public void alpha_may_contain_digits_if_specified(){
        HumanBeing hb = new HumanBeing("A").setPhone("ButęHąreMałBaźżAPhoneNumberLike700800900");
        ClassValidator<HumanBeing> cv = new ClassValidator<HumanBeing>(HumanBeing.class);
        ValidatorTestHelper.assertTrueOrShowErrors(hb, cv, true);
    }
    @Test
    public void alpha_may_contain_white_spaces_if_specified(){
        HumanBeing hb = new HumanBeing("AĆ").setPhone("BĄ9").setPhoneWithSpaces("Phone 48 700 800 900");
        ClassValidator<HumanBeing> cv = new ClassValidator<HumanBeing>(HumanBeing.class);
        ValidatorTestHelper.assertTrueOrShowErrors(hb, cv, true);
    }
    @Test
    public void alpha_may_contain_white_spaces_without_digits_if_specified(){
        HumanBeing hb = new HumanBeing("AĆ").setPhone("B9").setPhoneWithSpaces("9 A").setNames("Sir Wright Blę Blą");
        ClassValidator<HumanBeing> cv = new ClassValidator<HumanBeing>(HumanBeing.class);
        ValidatorTestHelper.assertTrueOrShowErrors(hb, cv, true);
    }
    @Test
    public void alpha_may_be_null_by_default(){
        HumanBeing hb = new HumanBeing("AĆ").setOptionalGender(null);
        ClassValidator<HumanBeing> cv = new ClassValidator<HumanBeing>(HumanBeing.class);
        ValidatorTestHelper.assertTrueOrShowErrors(hb, cv, true);
    }
}
