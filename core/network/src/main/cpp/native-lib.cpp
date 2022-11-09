//
// Created by Stefanus Ayudha on 18/04/2022.
// email: stefanus.ayudha@gmail.com
//

#include <jni.h>
#include <string>
extern "C"
JNIEXPORT jstring JNICALL
Java_com_stefanus_1ayudha_core_network_data_SecuredDev_getBaseUrl(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("https://jsonplaceholder.typicode.com/");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_stefanus_1ayudha_core_network_data_SecuredDev_getBasePokemonUrl(JNIEnv *env,
                                                                         jobject thiz) {
    return env->NewStringUTF("https://beta.pokeapi.co/graphql/v1beta");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_stefanus_1ayudha_core_network_data_SecuredStaging_getBaseUrl(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("https://jsonplaceholder.typicode.com/");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_stefanus_1ayudha_core_network_data_SecuredStaging_getBasePokemonUrl(JNIEnv *env,
                                                                             jobject thiz) {
    return env->NewStringUTF("https://beta.pokeapi.co/graphql/v1beta");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_stefanus_1ayudha_core_network_data_SecuredProd_getBaseUrl(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("https://jsonplaceholsssssder.typicode.com/");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_stefanus_1ayudha_core_network_data_SecuredProd_getBasePokemonUrl(JNIEnv *env,
                                                                          jobject thiz) {
    return env->NewStringUTF("https://beta.pokeapi.co/graphql/v1beta");
}