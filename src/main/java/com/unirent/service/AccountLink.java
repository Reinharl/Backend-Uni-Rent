import com.stripe.Stripe;
import com.stripe.model.AccountLink;
import com.stripe.param.AccountLinkCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Autowired
    private StripeConfig stripeConfig;

    public void createAccountLink(String connectedAccountId) {
        Stripe.apiKey = stripeConfig.getStripeSecretKey();

        AccountLinkCreateParams params = AccountLinkCreateParams.builder()
                .setAccount(connectedAccountId)
                .setRefreshUrl("https://example.com/reauth")
                .setReturnUrl("https://example.com/return")
                .setType(AccountLinkCreateParams.Type.ACCOUNT_ONBOARDING)
                .build();

        AccountLink accountLink = AccountLink.create(params);
    }
}
