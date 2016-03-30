CREATE SCHEMA ai_rest_api
  AUTHORIZATION stefan;
GRANT ALL ON SCHEMA ai_rest_api TO stefan;
GRANT USAGE ON SCHEMA ai_rest_api TO mspublic;


CREATE TABLE ai_rest_api.canton
(
  ogc_fid serial NOT NULL,
  fosnr integer NOT NULL UNIQUE,
  code character varying(2) NOT NULL UNIQUE,
  aname character varying(255) NOT NULL UNIQUE,
  email character varying(255),
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


CREATE TABLE ai_rest_api.model
(
  ogc_fid serial NOT NULL,
  canton character varying(2) NOT NULL,
  aname character varying(255) NOT NULL,
  schema_language character varying(6) NOT NULL,
  version character varying(255) NOT NULL,
  publishing_date date NOT NULL DEFAULT NOW(),
  repository character varying(255) NOT NULL,
  activated boolean DEFAULT TRUE,
  CONSTRAINT model_pkey PRIMARY KEY (ogc_fid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ai_rest_api.model OWNER TO stefan;
GRANT ALL ON TABLE ai_rest_api.model TO stefan;
GRANT SELECT ON TABLE ai_rest_api.model TO mspublic;
