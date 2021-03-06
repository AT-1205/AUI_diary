PGDMP     2                     z            oop_project    14.0    14.0     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    17051    oop_project    DATABASE     h   CREATE DATABASE oop_project WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1252';
    DROP DATABASE oop_project;
                postgres    false            ?            1259    25302    tasks    TABLE     ?   CREATE TABLE public.tasks (
    deadline character varying(50) NOT NULL,
    course character varying(100) NOT NULL,
    task character varying(200) NOT NULL,
    username character varying(50) NOT NULL
);
    DROP TABLE public.tasks;
       public         heap    postgres    false            ?            1259    25248 
   users_list    TABLE     L  CREATE TABLE public.users_list (
    "ID" bigint NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    username character varying(50) NOT NULL,
    course character varying(50) NOT NULL,
    pass_word character varying(50) NOT NULL
);
    DROP TABLE public.users_list;
       public         heap    postgres    false            ?            1259    25251    users_list_ID_seq    SEQUENCE     |   CREATE SEQUENCE public."users_list_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public."users_list_ID_seq";
       public          postgres    false    209            ?           0    0    users_list_ID_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public."users_list_ID_seq" OWNED BY public.users_list."ID";
          public          postgres    false    210            `           2604    25252    users_list ID    DEFAULT     r   ALTER TABLE ONLY public.users_list ALTER COLUMN "ID" SET DEFAULT nextval('public."users_list_ID_seq"'::regclass);
 >   ALTER TABLE public.users_list ALTER COLUMN "ID" DROP DEFAULT;
       public          postgres    false    210    209            ?          0    25302    tasks 
   TABLE DATA           A   COPY public.tasks (deadline, course, task, username) FROM stdin;
    public          postgres    false    211   #       ?          0    25248 
   users_list 
   TABLE DATA           e   COPY public.users_list ("ID", first_name, last_name, email, username, course, pass_word) FROM stdin;
    public          postgres    false    209   ?       ?           0    0    users_list_ID_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public."users_list_ID_seq"', 20, true);
          public          postgres    false    210            d           2606    25309    tasks tasks_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (username, task, course, deadline);
 :   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_pkey;
       public            postgres    false    211    211    211    211            b           2606    25307    users_list users_list_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.users_list
    ADD CONSTRAINT users_list_pkey PRIMARY KEY (username);
 D   ALTER TABLE ONLY public.users_list DROP CONSTRAINT users_list_pkey;
       public            postgres    false    209            ?   b  x??S?n?0?????T?y??@???J]???&?6??v???7??<?????s???????,
H??
K^K<RT4??	g,d#6??????`?Ñ???"??ԁ?????YV???ux?rNf?Hʢ?deD?0l?w??7H?J:G?d?i?x?S?v¡u??gG?/(w??6??&??h.??t}?$??Y?FS?@??r?)O??(,?t[k?3s??_;oݍO,$s??t)??pg?AK?)?EW?ԓz????;????Vt	n?Ӟ?|?Y?CQPؗ'???u??΍????q?cEM??ěz?Al??)m???O;??????O'???l=???B???_V??? ??b      ?   a  x?u?ώ?0????????mIUU?6?!???e 7?;?qV??;??V??槙O??|N!?j???????"`D|???v?pQyޜ!K?4Y&?>~?dɇ\m^[???)E	?An?o??Rww??x??=V^%???{5?b?d???ԠT
??ȸ??c?u????`??-??
?????c_???qw?m????z????[A?D?PW???Ѝ?3??l??]?/K?D?ZA5=?5|?V??W?????;?Y?n?Lw???aiQ?D%i?/idOM???F?eD???:?$?B???%j??t4?Z???%???7Ļ	?L?Oc(??a;?[ii??%?i4]?q???lG?=X???I?*??AEĈc??%???u??-?Y\?(KS:?;أ<U????9?M?c?/??Y?{?h?#??x???`=?`?T????,]?r??"?랼W??wo8????f??=hq???uemJC?4?%M?0?!?J???;??SY?N+L?AFc?U?k?p????Cp????jz?U?ό4?+Q???$??3?݂??4??L??at?d+??HO??
???	<?ۭ?????p??c? \]?|     