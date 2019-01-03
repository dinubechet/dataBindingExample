package codingwithmitch.com.databindinggettingstarted;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import codingwithmitch.com.databindinggettingstarted.databinding.ActivityMainBinding;
import codingwithmitch.com.databindinggettingstarted.models.Product;
import codingwithmitch.com.databindinggettingstarted.util.Products;

public class MainActivity extends AppCompatActivity implements IMainActivity{
    ActivityMainBinding mBindings;

   private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBindings = DataBindingUtil.setContentView(this,R.layout.activity_main );

        Products products = new Products();
        mProduct = products.PRODUCTS[0];

       mBindings.setProduct(mProduct);
       mBindings.setQuantity(1);
       mBindings.setIMainActivity((IMainActivity)this);
    }

    @Override
    public void inflateQuantityDialog() {
        ChooseQuantityDialog dialog = new ChooseQuantityDialog();
        dialog.show(getSupportFragmentManager(),getString(R.string.dialog_choose_quantity));
    }

    @Override
    public void setQuantity(int quantity) {
        mBindings.setQuantity(quantity);
    }
}
