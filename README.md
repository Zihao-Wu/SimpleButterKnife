一个轻量级的ButterKnife库，主要功能是为了解放  ButtonView bt=(ButtonView)findViewById(R.id.layout_root); 操作。
  通过对成员变量注解BindView(R.id.xx)，和在onCreate(Bundle savedInstanceState)等方法中 调用ButterKnife.bindView(this);完成对view的findView赋值。
  节省findViewById()代码和大量繁琐代码。目前主要适用场合为Activity、Fragment、和自定义view等其它场景，如果使用中有问题，欢迎积极pull 和 issues,如果您
  觉的还有什么好的功能或建议，也可留言。希望大家用的开心。。。。
  
  public class MainActivity extends BaseActivity {

    @BindView(R.id.text_view)
    private TextView mTextView;

    @BindView(R.id.button)
    private Button mButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bindView(this);

        mButton.setText("New Button");
    }
  }
  
  public class BlankFragment extends Fragment {

    @BindView(R.id.custom)
    private CustomView mCustomView;

    @BindView(R.id.text_view)
    TextView mTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bindView(this);
        initView();
    }
  }
  
  public class CustomView extends LinearLayout{

    @BindView(R.id.button)
    private Button mButton;

    @BindView(R.id.checkbox) private CheckBox mCheckBox;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.view_custom,null);
        addView(view);

        ButterKnife.bindView(this);

        mButton.setText("child Button");
        mCheckBox.setText("ButterKnife.bindView(View customView)");

    }
}
  
