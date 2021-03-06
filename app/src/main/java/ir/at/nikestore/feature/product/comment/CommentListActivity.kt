package ir.at.nikestore.feature.product.comment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sevenlearn.nikestore.data.Comment
import com.sevenlearn.nikestore.feature.product.CommentAdapter
import com.sevenlearn.nikestore.feature.product.comment.CommentListViewModel
import ir.at.nikestore.NikeActivity
import ir.at.nikestore.R
import ir.at.nikestore.common.EXTRA_KEY_ID
import kotlinx.android.synthetic.main.activity_comment_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CommentListActivity : NikeActivity() {

    val viewModel : CommentListViewModel by viewModel{ parametersOf(intent.extras!!.getInt(EXTRA_KEY_ID))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_list)

        viewModel.progressBarLiveData.observe(this){
            setProgressIndicator(it)
        }

        viewModel.commentsLiveData.observe(this){
            val adapter = CommentAdapter(true)
            commentsRv.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL , false)
            commentsRv.adapter = adapter

            adapter.comments = it as ArrayList<Comment>
        }

        commentListToolbar.onBackButtonClickListener = View.OnClickListener {
            finish()
        }
    }
}