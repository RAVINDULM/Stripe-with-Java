import java.util.HashMap;
        import java.util.Map;
        import com.stripe.Stripe;
        import com.stripe.exception.StripeException;
        import com.stripe.model.Charge;

public class Stripewithjava  {

    public static void main(String[] args) throws StripeException {
        // Set your secret key: remember to change this to your live secret key in production
        // Find your keys here: https://dashboard.stripe.com/account/apikeys
        Stripe.apiKey = "sk_test_your_secret_key";

        // Create a charge: this will charge the user's card
        Map<String, Object> params = new HashMap<>();
        params.put("amount", 1000); // amount in cents
        params.put("currency", "USD");
        params.put("source", "tok_visa"); // obtained with Stripe.js
        params.put("description", "Charge for test@example.com");

        try {
            Charge charge = Charge.create(params);
            System.out.println(charge);
        } catch (StripeException e) {
            System.out.println(e);
        }
    }
}
