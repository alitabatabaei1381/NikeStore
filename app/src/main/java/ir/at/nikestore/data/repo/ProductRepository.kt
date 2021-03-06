package ir.at.nikestore.data.repo

import io.reactivex.Completable
import io.reactivex.Single
import ir.at.nikestore.data.Product

interface ProductRepository {

    fun getProducts(sort:Int) : Single<List<Product>>

    fun getFavoriteProduct() : Single<List<Product>>

    fun addToFavorite(product: Product) : Completable

    fun deleteFromFavorite(product: Product) : Completable

}