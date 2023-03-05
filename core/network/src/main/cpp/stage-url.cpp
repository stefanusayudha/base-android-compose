//
// Created by Stefanus Ayudha on 18/04/2022.
// email: stefanus.ayudha@gmail.com
//

#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_singularity_1code_core_network_util_SecuredStaging_getBaseUrl(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("https://jsonplaceholder.typicode.com/");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_singularity_1code_core_network_util_SecuredStaging_getBasePokemonUrl(JNIEnv *env,
                                                                              jobject thiz) {
    return env->NewStringUTF("https://beta.pokeapi.co/graphql/v1beta");
}