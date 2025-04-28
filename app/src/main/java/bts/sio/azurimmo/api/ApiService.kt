import bts.sio.azurimmo.model.Appartement
import bts.sio.azurimmo.model.Batiment
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("batiments")
    suspend fun getBatiments(): List<Batiment>

    @GET("batiments/{id}")
    suspend fun getBatimentById(@Path("id") id: String): Batiment

    @GET("appartements")
    suspend fun getAppartements(): List<Appartement>

    @GET("/appartements{id}")
    suspend fun getAppartementsById(@Path("id") id: String): Appartement

    @GET("appartement/batiment{id}")
    suspend fun getAppartementsByBatimentId(@Path("id") batimentId: String): List<Appartement>

}
