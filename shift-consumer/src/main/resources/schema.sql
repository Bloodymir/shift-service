drop table if exists shift CASCADE;
drop table if exists allowance CASCADE;
drop table if exists break CASCADE;
drop table if exists award_interpretation CASCADE;
drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 1 increment by 1;

create table if not exists shift (
    id integer not null primary key,
    timesheet_id integer,
    user_id integer,
    shift_date date,
    start timestamp with time zone,
    finish timestamp with time zone,
    break_start timestamp with time zone,
    break_finish timestamp with time zone,
    approved_at timestamp with time zone,
    updated_at timestamp with time zone,
    last_costed_at timestamp with time zone,
    break_length integer,
    status varchar(20),

    tag varchar(255),
    tag_id integer,
    sub_cost_centre varchar(255),
    cost float,

    department_id integer,
    metadata varchar(255),
    record_id integer,
    leave_request_id integer,
    approved_by integer
);

create table if not exists allowance (
    id bigint not null primary key,
    name varchar(255),
    allowance_value float,
    cost float,
    shift_id integer ,
    shift_timesheet_id integer,
    shift_date date
);

create table if not exists break (
    id bigint not null primary key,
    start timestamp with time zone,
    finish timestamp with time zone,
    break_length integer,
    shift_id integer ,
    shift_timesheet_id integer,
    shift_date date,
    paid boolean
);

create table if not exists award_interpretation (
    id bigint not null primary key auto_increment,

    units float,
    award_date date,
    export_name varchar(255),
    secondary_export_name varchar(255),
    ordinary_hours boolean,
    cost float,
    award_from timestamp with time zone,
    award_to timestamp with time zone,

    shift_id integer ,
    shift_timesheet_id integer,
    shift_date date
);
