PGDMP  "                    }            pacienteumg    17.3    17.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    24576    pacienteumg    DATABASE     q   CREATE DATABASE pacienteumg WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en-US';
    DROP DATABASE pacienteumg;
                     postgres    false            �            1259    24578    paciente    TABLE     �   CREATE TABLE public.paciente (
    id integer NOT NULL,
    nombre text NOT NULL,
    direccion text NOT NULL,
    telefono text NOT NULL
);
    DROP TABLE public.paciente;
       public         heap r       postgres    false            �            1259    24577    paciente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.paciente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.paciente_id_seq;
       public               postgres    false    218            �           0    0    paciente_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.paciente_id_seq OWNED BY public.paciente.id;
          public               postgres    false    217            W           2604    24581    paciente id    DEFAULT     j   ALTER TABLE ONLY public.paciente ALTER COLUMN id SET DEFAULT nextval('public.paciente_id_seq'::regclass);
 :   ALTER TABLE public.paciente ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    218    217    218            �          0    24578    paciente 
   TABLE DATA           C   COPY public.paciente (id, nombre, direccion, telefono) FROM stdin;
    public               postgres    false    218   �
       �           0    0    paciente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.paciente_id_seq', 5, true);
          public               postgres    false    217            Y           2606    24585    paciente paciente_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.paciente DROP CONSTRAINT paciente_pkey;
       public                 postgres    false    218            �   M   x�3��LN��JLN,H�46153��4�2��)���B��͸L���ŉ�9�
�9�%@F\����E@t�b���� ���     