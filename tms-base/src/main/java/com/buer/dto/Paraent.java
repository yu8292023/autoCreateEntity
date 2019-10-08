package com.buer.dto;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
 *
Q : reqDTO
S : resDTO
T : entity
**/
public class Paraent<Q,S,T> {

        public S queryDao(Q q){
            S s = null;
                s = getEntiy();
            return s;
        }

        public S getEntiy()  {
            ParameterizedType superclass = (ParameterizedType)this.getClass().getGenericSuperclass();
            Type[] actualTypeArguments = superclass.getActualTypeArguments();
            Class<Q> clazz = (Class<Q>)actualTypeArguments[0];
            Class<S> clazz1 = (Class<S>)actualTypeArguments[1];
            Class<T> clazz2 = (Class<T>)actualTypeArguments[2];
            try {
                Q o = (Q) clazz.newInstance();
                S o1 = (S)clazz1.newInstance();
                T o2 = (T)clazz2.newInstance();
                return o1;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;

        }

}