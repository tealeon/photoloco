/*locations*/
insert into location(id, longitude, latitude, name, description, tag)
values (1001, 48.30639, 14.28611, 'Linz', 'city in Austria','urban 🏙️');
insert into location(id, longitude, latitude, name, description, tag)
values (1002, 48.210033, 16.363449, 'Wien', 'city in Austria','urban 🏙️');
insert into location(id, longitude, latitude, name, description, tag)
values (1003, 47.076668, 15.421371, 'Graz', 'city in Austria','urban 🏙️');
insert into location(id, longitude, latitude, name, description, tag)
values (1004, 48.27965, 14.2533, 'Leonding', 'city in Austria','urban 🏙️');
insert into location(id, longitude, latitude, name, description, tag)
values (1005, 48.20969, 14.29004, 'Ansfelden', 'city in Austria','urban 🏙️');
insert into location(id, longitude, latitude, name, description, tag)
values (1006, 47.79941, 13.04399, 'Salzburg', 'city in Austria','urban 🏙️');
insert into location(id, longitude, latitude, name, description, tag)
values (1007, 47.26266, 11.39454, 'Innsbruck', 'city in Austria','romantic 🌹');
insert into location(id, longitude, latitude, name, description, tag)
values (1008, 48.25628, 13.04343, 'Braunau am Inn', 'city in Austria','nature 🍃');

/*users*/
insert into _user (id, biography, city, country, email, firstname, imageurl, instagramname, ismodel, isphotographer, lastname, username, websiteurl)
values (1, 'photographer without regrets', 'Linz', 'Austria', 'ltea@mail.com', 'Leon', 'https://scontent-vie1-1.cdninstagram.com/v/t51.2885-19/s320x320/124188864_879588679243345_2016517700226628149_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com&_nc_ohc=jxwmT_BID8QAX-SrS_Z&tp=1&oh=62d724ca21bd4192f7175d5bd0e5783a&oe=6051B5A7', 'leon.tea', false, true, 'Tea', 'leonn', 'www.google.com');

insert into _user (id, biography, city, country, email, firstname, imageurl, instagramname, ismodel, isphotographer, lastname, username, websiteurl)
values (2, '📷 | 🌍 | 🇦🇹 | 📍 Linz ✉️ DM for photoshooting', 'Linz', 'Austria', 'fran@mail.com', 'Francis', 'https://scontent-vie1-1.cdninstagram.com/v/t51.2885-19/s320x320/121616104_1772376002918196_6595898946490198361_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com&_nc_ohc=cmmWRENo3fkAX-dQlD3&tp=1&oh=023a208beafc6e792f4c99811b087d8d&oe=60511EBD', 'francis_liger', false, true, 'Ehmeir', 'franciss', 'www.google.com');

insert into _user (id, biography, city, country, email, firstname, imageurl, instagramname, ismodel, isphotographer, lastname, username, websiteurl)
values (3, '🦄', 'Linz', 'Austria', 'loo@mail.com', 'Lorenz', 'https://www.borgleon.at/wp-content/uploads/2015/10/default-user-image.png', 'l.0o0o0', false, true, 'Gruber', 'Loo', 'www.google.com');

insert into _user (id, biography, city, country, email, firstname, imageurl, instagramname, ismodel, isphotographer, lastname, username, websiteurl)
values (4, '🕊 𝘑𝘰𝘩𝘯 𝟣𝟥:𝟩', 'Linz', 'Austria', 'marxa@mail.com', 'Maria', 'https://scontent-vie1-1.cdninstagram.com/v/t51.2885-19/s320x320/146946455_482994266021683_5282674739716486629_n.jpg?_nc_ht=scontent-vie1-1.cdninstagram.com&_nc_ohc=JUYYySgg3AAAX_D1Q5L&tp=1&oh=d2a2c09a7aed0f044f93bc2882316f56&oe=604E9F56', 'marxamlc', true, true, 'Milic', 'MΛЯIΛ', 'www.google.com');

insert into _user (id, biography, city, country, email, firstname, imageurl, instagramname, ismodel, isphotographer, lastname, username, websiteurl)
values (5, '', 'Linz', 'Austria', 'hope@mail.com', 'Hope', 'https://www.borgleon.at/wp-content/uploads/2015/10/default-user-image.png', 'hope_snr', true, false, 'Senegal', 'Hopee', 'www.google.com');

/*posts*/
insert into post (id, dateofcreation, markdowncontent, title, author_id)
values (1000, '2020-03-22', 'Hi! I am currently using my ISRE animal camera and but ive had it for 6 years now and its time to upgrade', 'In need of a new camera. I would very much appreciate recommendations.', 3);
insert into post (id, dateofcreation, markdowncontent, title, author_id)
values (1002, '2017-03-26', 'Hello World!', 'My First Post', 1);
insert into post (id, dateofcreation, markdowncontent, title, author_id)
values (1001, '2019-05-28', 'What gear should I get as a beginner?', 'Asking for advice', 3);

/*postComments*/
insert into postComment (id, content, author_id, post_id, postrepliedto_id)
values (1000, 'just get the Sony A7S III!', 2, 1000, null);
insert into postComment (id, content, author_id, post_id, postrepliedto_id)
values (1001, 'Canon R5.', 1, 1000, null);