package ru.geekbrains.clientgithub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.card_user_fragment.*
import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.databinding.CardUserFragmentBinding

class CardUserFragment : Fragment() {
    companion object {
        fun newInstance(bundle: Bundle?) : CardUserFragment {
            val fragment = CardUserFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: CardUserFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CardUserFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = arguments?.getParcelable<User>("USER")

        binding.nameUserTextView.text = user?.title?.name ?: ""
        user?.title?.image?.let { binding.userImageView.setImageResource(it) }
        //user_image_view.findViewById<ImageView>(R.id.user_item_image_view).setImageResource(user.title.image)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}