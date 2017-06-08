--Create busdetails

CREATE TABLE public.busdetails
(
    busdetails_id integer NOT NULL,
    route_num character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT busdetails_pkey PRIMARY KEY (busdetails_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.busdetails
    OWNER to postgres;

--Create Route

CREATE TABLE public.route
(
    route_id integer NOT NULL,
    destination character varying(255) COLLATE pg_catalog."default",
    source character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT route_pkey PRIMARY KEY (route_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.route
    OWNER to postgres;

--Create busroute_details

CREATE TABLE public.busroute_details
(
    busdetails_id integer NOT NULL,
    route_id integer NOT NULL,
    CONSTRAINT busroute_details_pkey PRIMARY KEY (busdetails_id, route_id),
    CONSTRAINT busdetails_id FOREIGN KEY (busdetails_id)
        REFERENCES public.busdetails (busdetails_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT route_id FOREIGN KEY (route_id)
        REFERENCES public.route (route_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.busroute_details
    OWNER to postgres;