CREATE SCHEMA ai_rest_api
  AUTHORIZATION stefan;
GRANT ALL ON SCHEMA ai_rest_api TO stefan;
GRANT USAGE ON SCHEMA ai_rest_api TO mspublic;


CREATE TABLE ai_rest_api.canton
(
  ogc_fid serial NOT NULL,
  fosnr integer NOT NULL,
  code character varying(2) NOT NULL,
  aname character varying(255) NOT NULL,
  activated boolean DEFAULT FALSE,
  geometrie geometry(MultiPolygon,2056),
  CONSTRAINT canton_pkey PRIMARY KEY (ogc_fid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ai_rest_api.canton OWNER TO stefan;
GRANT ALL ON TABLE ai_rest_api.canton TO stefan;
GRANT SELECT ON TABLE ai_rest_api.canton TO mspublic;
