PGDMP     3                    {            vet    13.13    13.13 >    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    17784    vet    DATABASE     a   CREATE DATABASE vet WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_T�rkiye.1254';
    DROP DATABASE vet;
                postgres    false            �            1259    20242    animal_vaccines    TABLE     �   CREATE TABLE public.animal_vaccines (
    id bigint NOT NULL,
    protection_end date NOT NULL,
    protection_start date NOT NULL,
    animal_id bigint,
    vaccine_id bigint
);
 #   DROP TABLE public.animal_vaccines;
       public         heap    postgres    false            �            1259    20240    animal_vaccines_id_seq    SEQUENCE        CREATE SEQUENCE public.animal_vaccines_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.animal_vaccines_id_seq;
       public          postgres    false    201                       0    0    animal_vaccines_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.animal_vaccines_id_seq OWNED BY public.animal_vaccines.id;
          public          postgres    false    200            �            1259    20250    animals    TABLE     �  CREATE TABLE public.animals (
    id bigint NOT NULL,
    birthday date,
    breed character varying(255),
    colour character varying(255),
    gender character varying(255),
    name character varying(255),
    species character varying(255),
    customer_id bigint,
    CONSTRAINT animals_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying])::text[])))
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    20248    animals_id_seq    SEQUENCE     w   CREATE SEQUENCE public.animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.animals_id_seq;
       public          postgres    false    203                       0    0    animals_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;
          public          postgres    false    202            �            1259    20262    appointments    TABLE     �   CREATE TABLE public.appointments (
    id bigint NOT NULL,
    appointment_date timestamp(6) without time zone NOT NULL,
    animal_id bigint NOT NULL,
    doctor_id bigint NOT NULL
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    20260    appointments_id_seq    SEQUENCE     |   CREATE SEQUENCE public.appointments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.appointments_id_seq;
       public          postgres    false    205                       0    0    appointments_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.appointments_id_seq OWNED BY public.appointments.id;
          public          postgres    false    204            �            1259    20270 	   customers    TABLE       CREATE TABLE public.customers (
    id bigint NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255),
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    20268    customers_id_seq    SEQUENCE     y   CREATE SEQUENCE public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.customers_id_seq;
       public          postgres    false    207                       0    0    customers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;
          public          postgres    false    206            �            1259    20281    doctor_available_days    TABLE     ~   CREATE TABLE public.doctor_available_days (
    id bigint NOT NULL,
    available_days date NOT NULL,
    doctor_id bigint
);
 )   DROP TABLE public.doctor_available_days;
       public         heap    postgres    false            �            1259    20279    doctor_available_days_id_seq    SEQUENCE     �   CREATE SEQUENCE public.doctor_available_days_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.doctor_available_days_id_seq;
       public          postgres    false    209                       0    0    doctor_available_days_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.doctor_available_days_id_seq OWNED BY public.doctor_available_days.id;
          public          postgres    false    208            �            1259    20289    doctors    TABLE       CREATE TABLE public.doctors (
    id bigint NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255),
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    20287    doctors_id_seq    SEQUENCE     w   CREATE SEQUENCE public.doctors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.doctors_id_seq;
       public          postgres    false    211                       0    0    doctors_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.doctors_id_seq OWNED BY public.doctors.id;
          public          postgres    false    210            �            1259    20300    vaccines    TABLE     �   CREATE TABLE public.vaccines (
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255) NOT NULL
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    20298    vaccines_id_seq    SEQUENCE     x   CREATE SEQUENCE public.vaccines_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.vaccines_id_seq;
       public          postgres    false    213                       0    0    vaccines_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.vaccines_id_seq OWNED BY public.vaccines.id;
          public          postgres    false    212            J           2604    20245    animal_vaccines id    DEFAULT     x   ALTER TABLE ONLY public.animal_vaccines ALTER COLUMN id SET DEFAULT nextval('public.animal_vaccines_id_seq'::regclass);
 A   ALTER TABLE public.animal_vaccines ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            K           2604    20253 
   animals id    DEFAULT     h   ALTER TABLE ONLY public.animals ALTER COLUMN id SET DEFAULT nextval('public.animals_id_seq'::regclass);
 9   ALTER TABLE public.animals ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            M           2604    20265    appointments id    DEFAULT     r   ALTER TABLE ONLY public.appointments ALTER COLUMN id SET DEFAULT nextval('public.appointments_id_seq'::regclass);
 >   ALTER TABLE public.appointments ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            N           2604    20273    customers id    DEFAULT     l   ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);
 ;   ALTER TABLE public.customers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            O           2604    20284    doctor_available_days id    DEFAULT     �   ALTER TABLE ONLY public.doctor_available_days ALTER COLUMN id SET DEFAULT nextval('public.doctor_available_days_id_seq'::regclass);
 G   ALTER TABLE public.doctor_available_days ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            P           2604    20292 
   doctors id    DEFAULT     h   ALTER TABLE ONLY public.doctors ALTER COLUMN id SET DEFAULT nextval('public.doctors_id_seq'::regclass);
 9   ALTER TABLE public.doctors ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            Q           2604    20303    vaccines id    DEFAULT     j   ALTER TABLE ONLY public.vaccines ALTER COLUMN id SET DEFAULT nextval('public.vaccines_id_seq'::regclass);
 :   ALTER TABLE public.vaccines ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    213    213            �          0    20242    animal_vaccines 
   TABLE DATA           f   COPY public.animal_vaccines (id, protection_end, protection_start, animal_id, vaccine_id) FROM stdin;
    public          postgres    false    201   �H       �          0    20250    animals 
   TABLE DATA           b   COPY public.animals (id, birthday, breed, colour, gender, name, species, customer_id) FROM stdin;
    public          postgres    false    203   �H       �          0    20262    appointments 
   TABLE DATA           R   COPY public.appointments (id, appointment_date, animal_id, doctor_id) FROM stdin;
    public          postgres    false    205   kI       �          0    20270 	   customers 
   TABLE DATA           I   COPY public.customers (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    207   �I       �          0    20281    doctor_available_days 
   TABLE DATA           N   COPY public.doctor_available_days (id, available_days, doctor_id) FROM stdin;
    public          postgres    false    209   (J       �          0    20289    doctors 
   TABLE DATA           G   COPY public.doctors (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    211   kJ       �          0    20300    vaccines 
   TABLE DATA           2   COPY public.vaccines (id, code, name) FROM stdin;
    public          postgres    false    213   �J       	           0    0    animal_vaccines_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.animal_vaccines_id_seq', 7, true);
          public          postgres    false    200            
           0    0    animals_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.animals_id_seq', 8, true);
          public          postgres    false    202                       0    0    appointments_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.appointments_id_seq', 23, true);
          public          postgres    false    204                       0    0    customers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.customers_id_seq', 5, true);
          public          postgres    false    206                       0    0    doctor_available_days_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.doctor_available_days_id_seq', 9, true);
          public          postgres    false    208                       0    0    doctors_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.doctors_id_seq', 5, true);
          public          postgres    false    210                       0    0    vaccines_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.vaccines_id_seq', 5, true);
          public          postgres    false    212            S           2606    20247 $   animal_vaccines animal_vaccines_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.animal_vaccines
    ADD CONSTRAINT animal_vaccines_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.animal_vaccines DROP CONSTRAINT animal_vaccines_pkey;
       public            postgres    false    201            U           2606    20259    animals animals_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    203            W           2606    20267    appointments appointments_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    205            Y           2606    20278    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    207            _           2606    20286 0   doctor_available_days doctor_available_days_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.doctor_available_days
    ADD CONSTRAINT doctor_available_days_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.doctor_available_days DROP CONSTRAINT doctor_available_days_pkey;
       public            postgres    false    209            a           2606    20297    doctors doctors_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    211            [           2606    20310 &   customers uk_2hxsqcqvp2pjgxw00gn7inubj 
   CONSTRAINT     a   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT uk_2hxsqcqvp2pjgxw00gn7inubj UNIQUE (mail);
 P   ALTER TABLE ONLY public.customers DROP CONSTRAINT uk_2hxsqcqvp2pjgxw00gn7inubj;
       public            postgres    false    207            c           2606    20314 %   vaccines uk_7o57f9urdeta76xljqdidcsck 
   CONSTRAINT     `   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT uk_7o57f9urdeta76xljqdidcsck UNIQUE (code);
 O   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT uk_7o57f9urdeta76xljqdidcsck;
       public            postgres    false    213            ]           2606    20312 &   customers uk_m3iom37efaxd5eucmxjqqcbe9 
   CONSTRAINT     b   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT uk_m3iom37efaxd5eucmxjqqcbe9 UNIQUE (phone);
 P   ALTER TABLE ONLY public.customers DROP CONSTRAINT uk_m3iom37efaxd5eucmxjqqcbe9;
       public            postgres    false    207            e           2606    20308    vaccines vaccines_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    213            i           2606    20330 (   appointments fk95vepu86o8syqtux9gkr71bhy    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk95vepu86o8syqtux9gkr71bhy FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk95vepu86o8syqtux9gkr71bhy;
       public          postgres    false    203    2901    205            h           2606    20325 #   animals fkb36lt3kj4mrbdx5btxmp4j60n    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n FOREIGN KEY (customer_id) REFERENCES public.customers(id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n;
       public          postgres    false    207    2905    203            k           2606    20340 1   doctor_available_days fkhhnbfqustrh46vuehatdsv53r    FK CONSTRAINT     �   ALTER TABLE ONLY public.doctor_available_days
    ADD CONSTRAINT fkhhnbfqustrh46vuehatdsv53r FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 [   ALTER TABLE ONLY public.doctor_available_days DROP CONSTRAINT fkhhnbfqustrh46vuehatdsv53r;
       public          postgres    false    211    2913    209            f           2606    20315 +   animal_vaccines fkiwvg30h9kqewspm3hj6xl2kn9    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal_vaccines
    ADD CONSTRAINT fkiwvg30h9kqewspm3hj6xl2kn9 FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 U   ALTER TABLE ONLY public.animal_vaccines DROP CONSTRAINT fkiwvg30h9kqewspm3hj6xl2kn9;
       public          postgres    false    2901    201    203            j           2606    20335 (   appointments fkmujeo4tymoo98cmf7uj3vsv76    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76 FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76;
       public          postgres    false    205    2913    211            g           2606    20320 *   animal_vaccines fktx6d054a6qgimiblyxm4f5ue    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal_vaccines
    ADD CONSTRAINT fktx6d054a6qgimiblyxm4f5ue FOREIGN KEY (vaccine_id) REFERENCES public.vaccines(id);
 T   ALTER TABLE ONLY public.animal_vaccines DROP CONSTRAINT fktx6d054a6qgimiblyxm4f5ue;
       public          postgres    false    201    213    2917            �   K   x�M���0�on����������;0��u��.�b���h/��u���(�8�$[qH�؃����ˮ}      �   l   x�3�4202�50"���bΤ�RN_GW΂Ғ���TΜĤ�Ĕ�"NC.#�b4�n�`��9��%�F\�x���+7�2GvJ^>�%�.1����2tŦ\1z\\\ ��?�      �   O   x�U���0���
7�;'R��K��F���l��sE|�Pl�s�qSw������T4�C�i8g�e����w      �   N   x�-�9�0�z�1�\�B�����Kh�q�F��>H1УA�5�.πj�/ǈfM�|w�L�FЧ.�p�>H~d__      �   3   x�EǷ  ����#a���������Υ�[-$��(^��|����      �   }   x�5ʻ�0Eњ�"�e�4H�g���
�O���e�H6���8w�]��A����U�dG����]�#D�)a���3��!ĵn䡈L���|�$���4���!��)��ג5O~ݙ��D7�      �   I   x��A� �s�1F
��KC�� %�oo3�G�j��ItY�N�U��w"��[[1���i>������
�     