PGDMP                         x         
   chronicles    13.0    13.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    26216 
   chronicles    DATABASE     f   CREATE DATABASE chronicles WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE chronicles;
                postgres    false            �            1259    26226    cartas    TABLE       CREATE TABLE public.cartas (
    nombre character varying(50) NOT NULL,
    descripcion character varying(500),
    tipo character varying(30),
    pts_ataque integer DEFAULT 0,
    pts_defensa integer DEFAULT 0,
    pts_mana integer DEFAULT 0,
    nivel integer DEFAULT 0
);
    DROP TABLE public.cartas;
       public         heap    postgres    false            �            1259    26238    combates    TABLE       CREATE TABLE public.combates (
    jugador1 character varying(50),
    jugador2 character varying(50),
    victoria integer DEFAULT 0,
    derrota integer DEFAULT 0,
    empate integer DEFAULT 0,
    puntos_j1 integer DEFAULT 0,
    puntos_j2 integer DEFAULT 0
);
    DROP TABLE public.combates;
       public         heap    postgres    false            �            1259    26217    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    nickname character varying(50) NOT NULL,
    liga character varying(100) DEFAULT 'Ninguna'::character varying,
    nombre character varying(100),
    correo character varying(50),
    pass character varying(500)
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            �          0    26226    cartas 
   TABLE DATA           e   COPY public.cartas (nombre, descripcion, tipo, pts_ataque, pts_defensa, pts_mana, nivel) FROM stdin;
    public          postgres    false    201   T       �          0    26238    combates 
   TABLE DATA           g   COPY public.combates (jugador1, jugador2, victoria, derrota, empate, puntos_j1, puntos_j2) FROM stdin;
    public          postgres    false    202          �          0    26217    usuarios 
   TABLE DATA           H   COPY public.usuarios (nickname, liga, nombre, correo, pass) FROM stdin;
    public          postgres    false    200   v       7           2606    26237    cartas cartas_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.cartas
    ADD CONSTRAINT cartas_pkey PRIMARY KEY (nombre);
 <   ALTER TABLE ONLY public.cartas DROP CONSTRAINT cartas_pkey;
       public            postgres    false    201            5           2606    26225    usuarios usuarios_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (nickname);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    200            8           2606    26246    combates combates_jugador1_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.combates
    ADD CONSTRAINT combates_jugador1_fkey FOREIGN KEY (jugador1) REFERENCES public.usuarios(nickname);
 I   ALTER TABLE ONLY public.combates DROP CONSTRAINT combates_jugador1_fkey;
       public          postgres    false    202    200    2869            9           2606    26251    combates combates_jugador2_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.combates
    ADD CONSTRAINT combates_jugador2_fkey FOREIGN KEY (jugador2) REFERENCES public.usuarios(nickname);
 I   ALTER TABLE ONLY public.combates DROP CONSTRAINT combates_jugador2_fkey;
       public          postgres    false    202    200    2869            �   �   x�=�A
�0E��)��
�(�[7c3mCۙ:I��3x1�
������bs�GH�0b�Y���GO<� !�����*����j�^i0u�)/�i���a��O�3r��!�(]h�݆9��KZ���c 1�3̙<A�	�xA+:!�I.�$Z�@^��_IQK��V��9{�Yk��I�      �   P   x���/N5426�,H-�09������Ԁ+������\�*m	2��c�6 + I�`�)04 �6������ =�)/      �   �   x�U�Y�@E�g~E�4jዐ-�XӾħM6⌒cD��l���=�{`/�D�˨���ўY�6#�'��c�8���,z�f$�'Z�
�����[��x�Ϩ
ƶ�3��J���7YŎ�ӕ�%�ͯ���T�f�b��H�c�>ae��<I �F�c��F�:�P�E}���^H���܍[c|�R�     