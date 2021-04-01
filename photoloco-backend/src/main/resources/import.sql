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
values (100, 'photographer without regrets', 'Linz', 'Austria', 'ltea@mail.com', 'Leon', 'https://scontent-vie1-1.cdninstagram.com/v/t51.2885-19/s320x320/124188864_879588679243345_2016517700226628149_n.jpg?tp=1&_nc_ht=scontent-vie1-1.cdninstagram.com&_nc_ohc=hsY39r4TEOMAX9acdj8&ccb=7-4&oh=b2d269088fea6b9688d1f60fac850f8e&oe=607D3727', 'leon.tea', false, true, 'Tea', 'leonn', 'www.google.com');

insert into _user (id, biography, city, country, email, firstname, imageurl, instagramname, ismodel, isphotographer, lastname, username, websiteurl)
values (101, '📷 | 🌍 | 🇦🇹 | 📍 Linz ✉️ DM for photoshooting', 'Linz', 'Austria', 'fran@mail.com', 'Francis', 'https://scontent-vie1-1.cdninstagram.com/v/t51.2885-19/s320x320/121616104_1772376002918196_6595898946490198361_n.jpg?tp=1&_nc_ht=scontent-vie1-1.cdninstagram.com&_nc_ohc=zTm9_ObQVp0AX9PYwyK&ccb=7-4&oh=3ddde37c38657078bc2927a83c2ca720&oe=607CA03D', 'francis_liger', false, true, 'Ehmeir', 'franciss', 'www.google.com');

insert into _user (id, biography, city, country, email, firstname, imageurl, instagramname, ismodel, isphotographer, lastname, username, websiteurl)
values (102, '🦄', 'Linz', 'Austria', 'loo@mail.com', 'Lorenz', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png', 'l.0o0o0', false, true, 'Gruber', 'Loo', 'www.google.com');

insert into _user (id, biography, city, country, email, firstname, imageurl, instagramname, ismodel, isphotographer, lastname, username, websiteurl)
values (103, '🕊 𝘑𝘰𝘩𝘯 𝟣𝟥:𝟩', 'Linz', 'Austria', 'marxa@mail.com', 'Maria', 'https://scontent-vie1-1.cdninstagram.com/v/t51.2885-19/s320x320/160993473_737637333606873_7043829562003434334_n.jpg?tp=1&_nc_ht=scontent-vie1-1.cdninstagram.com&_nc_ohc=_kVjC8oyuJIAX8bzW3B&ccb=7-4&oh=90d358c7043893182e9a930a9ed8f2ca&oe=607BE578', 'marxamlc', true, true, 'Milic', 'MΛЯIΛ', 'www.google.com');

insert into _user (id, biography, city, country, email, firstname, imageurl, instagramname, ismodel, isphotographer, lastname, username, websiteurl)
values (104, '', 'Linz', 'Austria', 'hope@mail.com', 'Hope', 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png', 'hope_snr', true, false, 'Senegal', 'Hopee', 'www.google.com');

/*posts*/
insert into post (id, dateofcreation, markdowncontent, title, author_id)
values (1000, '2020-03-22', 'Hi! I am currently using my ISRE animal camera and but ive had it for 6 years now and its time to upgrade', 'In need of a new camera. I would very much appreciate recommendations.', 102);
insert into post (id, dateofcreation, markdowncontent, title, author_id)
values (1002, '2017-03-26', 'Hello World!', 'My First Post', 100);
insert into post (id, dateofcreation, markdowncontent, title, author_id)
values (1001, '2019-05-28', 'What gear should I get as a beginner?', 'Asking for advice', 102);

/*postComments*/
insert into postComment (id, content, author_id, post_id, postrepliedto_id)
values (1000, 'just get the Sony A7S III!', 101, 1000, null);
insert into postComment (id, content, author_id, post_id, postrepliedto_id)
values (1001, 'Canon R5.', 100, 1000, null);
