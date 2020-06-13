package com.example.jalilhuapp;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static int ID = 0;
    private static int ORDER_ID = 0;

    private static final String ALL_ITEMS_KEY = "all_items";
    private static final String DB_NAME = "fake_database";
    private static final String CART_ITEMS_KEY = "cart_items";
    private static Gson gson = new Gson();
    private static Type groceryListType = new TypeToken<ArrayList<GroceryItem>>(){}.getType();

    public static void initSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString(ALL_ITEMS_KEY, null), groceryListType);
        if (null == allItems) {
            initAllItems(context);
        }
    }

    public static void clearSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    private static void initAllItems(Context context) {
        ArrayList<GroceryItem> allItems = new ArrayList<>();
        allItems.add(new GroceryItem("Ice Cream", "ice cream. a rich, sweet, creamy frozen food made from variously flavored cream and milk products churned or stirred to a smooth consistency during the freezing process and often containing gelatin, eggs, fruits, nuts, etc",
                "https://3dpackshots.com/wp-content/uploads/2017/12/Golf-Royal-6.jpg",
                "Dairy", 20.49, 10));

        GroceryItem cocacola = new GroceryItem("CocaCola", "Coca-Cola, or Coke, is a carbonated soft drink manufactured by The Coca-Cola Company. Originally marketed as a temperance drink and intended as a patent medicine, it was invented in the late 19th century by John Stith Pemberton and was bought out by businessman Asa Griggs Candler , whose marketing tactics led Coca-Cola...",
                "https://bestilling.ths.dk/wp-content/uploads/2019/07/webprodukter-daese-CocaCola.jpg",
                "Beverages", 5.89, 200);
        allItems.add(cocacola);

        GroceryItem monster = new GroceryItem("Monster Energy Drink", "Monster Energy is an energy drink that was introduced by Hansen Natural Company in April of 2002. There are 34 different drinks under the Monster brand in North America, including its core Monster Energy line, Java Monster, Extra Strength, Import, Rehab and Muscle Monster.",
                "https://kfoodwholesale.com/wp-content/uploads/2018/11/Monster-Energy-Drink.jpeg",
                "Beverages", 15.00, 200);
        allItems.add(monster);

        GroceryItem pepsi = new GroceryItem("Pepsi", "Pepsi is a carbonated soft drink manufactured by PepsiCo . Originally created and developed in 1893 by Caleb Bradham and introduced as Brad's Drink, it was renamed as Pepsi-Cola on August 28, 1898, and then as Pepsi in 1961.",
                "https://groceryvillas.com/wp-content/uploads/2018/12/Untitled-1-1.jpg",
                "Beverages", 4.99, 15);
        allItems.add(pepsi);

        GroceryItem water = new GroceryItem("Water", "Gerolsteiner Mineral Water. Marketed in one of the simplest and most elegant looking bottles, Gerolsteiner has been serving as a good brand since 1988.",
                "https://cdn.barnimages.com/wp-content/uploads/2018/07/free-water-bottle-mockup-psd-3-740x555.jpg",
                "Beverages", 9.99, 15);
        allItems.add(water);

        GroceryItem mascara = new GroceryItem("Delux Lash Mascara", "En særlig nærende mascara til naturlige øjenvipper og lash extenstions, for mere fylde og glans af dine øjenvipper. Jo mere man lægger på, des tykkere",
                "https://www.bclspadanmark.dk/wp-content/uploads/2019/09/IMG_3917.jpeg",
                "Cosmetics", 229.00, 9);
        allItems.add(mascara);

        GroceryItem lipStick = new GroceryItem("MAC LipStick", "Mac Lipstick Colors, Best Mac Lipstick, Mac Matte Lipstick, Lipgloss, Mac Lipsticks, Bright Spring, Clear Spring, Warm Spring, Warm Autumn",
                "https://i.pinimg.com/originals/55/04/03/550403e132141daa10c515c6bb0f4da4.jpg",
                "Cosmetics", 156.00, 9);
        allItems.add(lipStick);

        GroceryItem eyeLiner = new GroceryItem("Super Liner", "Paradise mascara fra L'Oréal er en alt-i-en mascara der giver dig maks volumen og længde på samme tid. Paradise sætter helt nye standarder for en ...",
                "https://scale.coolshop-cdn.com/product-media.coolshop-cdn.com/AB3RX6/1a50e2216d1549258dc80dbd319b4235.jpeg/f/loreal-paris-super-liner-superstar-eyeliner-6ml-black.jpeg",
                "Cosmetics", 199.00, 9);
        allItems.add(eyeLiner);

        GroceryItem milk = new GroceryItem("Milk",
                "This low-fat milk is made from New Zealand and Australia milk. It is fortified with essential nutrients for better Calcium intake. High calcium content works in strengthen bone and teeth where Vitamin D is able to help the body to have better calcium absorption. This milk not only fulfills your calcium intake and yet also satisfy your taste bud, especially for those who can’t take cowy milk taste.",
                "https://2.bp.blogspot.com/-nKL_I3IRcqI/Xl3bVTFWwRI/AAAAAAAGmTw/LXJoh6_7QygXMnHEnWisRUQSEhZhGkEigCLcBGAsYHQ/s1600/Goodday-Balance-02.jpeg",
                "Dairy", 9.45, 6);

        allItems.add(milk);

        GroceryItem yogurt = new GroceryItem("Yogurt", "Dannon Light & Fit Non Fat Vanilla Greek Yogurt 4 Pack",
                "https://e22d0640933e3c7f8c86-34aee0c49088be50e3ac6555f6c963fb.ssl.cf2.rackcdn.com/0036632032490_CL_default_default_large.jpeg",
                "Dairy", 15.00, 14);
        allItems.add(yogurt);

        GroceryItem butter = new GroceryItem("Butter", "Hy-Vee Unsalted Sweet Butter Quarters",
                "https://0bb8856ba8259ec33e3d-a40599a114f3a4c6d0979c3ffe0b2bf5.ssl.cf2.rackcdn.com/0075450085150_CL_hyvee1_default_large.jpeg",
                "Beverages", 13.49, 25);
        allItems.add(butter);

        GroceryItem tv = new GroceryItem("TV", "HD 720p LED TV - 28'' Class (27.5'' Diag)",
                "https://www.lg.com/us/images/tvs/md05802269/gallery/medium01.jpg",
                "Electronics", 3500.50, 4);
        allItems.add(tv);

        GroceryItem soundbar = new GroceryItem("SoundBar", "Vizio SB2021n-G6 review: This budget 20-inch soundbar is the perfect match for a second TV",
                "https://images.idgesg.net/images/article/2020/01/vizio_sb2021n-g6_main.jpeg-100827819-large.3x2.jpg",
                "Electronics", 1500.85, 15);
        allItems.add(soundbar);

        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ALL_ITEMS_KEY, gson.toJson(allItems));
        editor.commit();
    }

    public static ArrayList<GroceryItem> getAllItems(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString(ALL_ITEMS_KEY, null), groceryListType);
        return allItems;
    }

    public static void changeRate(Context context, int itemId, int newRate) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString(ALL_ITEMS_KEY, null), groceryListType);
        if (null != allItems) {
            ArrayList<GroceryItem> newItems = new ArrayList<>();
            for (GroceryItem i: allItems) {
                if (i.getId() == itemId) {
                    i.setRate(newRate);
                    newItems.add(i);
                }else {
                    newItems.add(i);
                }
            }

            editor.remove(ALL_ITEMS_KEY);
            editor.putString(ALL_ITEMS_KEY, gson.toJson(newItems));
            editor.commit();
        }
    }

    public static void addReview(Context context, Review review) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ArrayList<GroceryItem> allItems = getAllItems(context);
        if (null != allItems) {
            ArrayList<GroceryItem> newItems = new ArrayList<>();
            for (GroceryItem i: allItems) {
                if (i.getId() == review.getGroceryItemId()) {
                    ArrayList<Review> reviews = i.getReviews();
                    reviews.add(review);
                    i.setReviews(reviews);
                    newItems.add(i);
                }else {
                    newItems.add(i);
                }
            }

            editor.remove(ALL_ITEMS_KEY);
            editor.putString(ALL_ITEMS_KEY, gson.toJson(newItems));
            editor.commit();
        }
    }

    public static ArrayList<Review> getReviewById(Context context, int itemId) {
        ArrayList<GroceryItem> allItems = getAllItems(context);
        if (null != allItems) {
            for (GroceryItem i: allItems) {
                if (i.getId() == itemId) {
                    ArrayList<Review> reviews = i.getReviews();
                    return reviews;
                }
            }
        }

        return null;
    }

    public static void addItemToCart (Context context, GroceryItem item) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<GroceryItem> cartItems = gson.fromJson(sharedPreferences.getString(CART_ITEMS_KEY, null), groceryListType);
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        cartItems.add(item);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(CART_ITEMS_KEY);
        editor.putString(CART_ITEMS_KEY, gson.toJson(cartItems));
        editor.commit();
    }

    public static ArrayList<GroceryItem> getCartItems(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<GroceryItem> cartItems = gson.fromJson(sharedPreferences.getString(CART_ITEMS_KEY, null), groceryListType);
        return cartItems;
    }

    public static ArrayList<GroceryItem> searchForItems(Context context, String text) {
        ArrayList<GroceryItem> allItems = getAllItems(context);
        if (null != allItems) {
            ArrayList<GroceryItem> items = new ArrayList<>();
            for (GroceryItem item: allItems) {
                if (item.getName().equalsIgnoreCase(text)) {
                    items.add(item);
                }

                String[] names = item.getName().split(" ");
                for (int i=0; i<names.length; i++) {
                    if (text.equalsIgnoreCase(names[i])) {
                        boolean doesExist = false;

                        for (GroceryItem j: items) {
                            if (j.getId() == item.getId()) {
                                doesExist = true;
                            }
                        }

                        if (!doesExist) {
                            items.add(item);
                        }
                    }
                }
            }

            return items;
        }

        return null;
    }

    public static ArrayList<String> getCategories(Context context) {
        ArrayList<GroceryItem> allItems = getAllItems(context);
        if (null != allItems) {
            ArrayList<String> categories = new ArrayList<>();
            for (GroceryItem item: allItems) {
                boolean doesExist = false;
                for (String s: categories) {
                    if (item.getCategory().equals(s)) {
                        doesExist = true;
                    }
                }

                if (!doesExist) {
                    categories.add(item.getCategory());
                }
            }

            return categories;
        }

        return null;
    }

    public static ArrayList<GroceryItem> getItemsByCategory (Context context, String category) {
        ArrayList<GroceryItem> allItems = getAllItems(context);
        if (null != allItems) {
            ArrayList<GroceryItem> items = new ArrayList<>();
            for (GroceryItem item: allItems) {
                if (item.getCategory().equals(category)) {
                    items.add(item);
                }
            }

            return items;
        }

        return null;
    }

    public static void deleteItemFromCart(Context context, GroceryItem item) {
        ArrayList<GroceryItem> cartItems = getCartItems(context);
        if (null != cartItems) {
            ArrayList<GroceryItem> newItems = new ArrayList<>();
            for (GroceryItem i: cartItems) {
                if (i.getId() != item.getId()) {
                    newItems.add(i);
                }
            }

            SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(CART_ITEMS_KEY);
            editor.putString(CART_ITEMS_KEY, gson.toJson(newItems));
            editor.commit();
        }
    }

    public static void clearCartItems(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(CART_ITEMS_KEY);
        editor.commit();
    }

    public static void increasePopularityPoint(Context context, GroceryItem item, int points) {
        ArrayList<GroceryItem> allItems = getAllItems(context);
        if (null != allItems) {
            ArrayList<GroceryItem> newItems = new ArrayList<>();
            for (GroceryItem i: allItems) {
                if (i.getId() == item.getId()) {
                    i.setPopularityPoint(i.getPopularityPoint() + points);
                    newItems.add(i);
                }else {
                    newItems.add(i);
                }
            }

            SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(ALL_ITEMS_KEY);
            Gson gson =new Gson();
            editor.putString(ALL_ITEMS_KEY, gson.toJson(newItems));
            editor.commit();
        }
    }

    public static int getID() {
        ID++;
        return ID;
    }

    public static int getOrderId() {
        ORDER_ID++;
        return ORDER_ID;
    }
    public static String getLicenses() {
        String licenses = "";

        //Gson
        licenses += "Gson\n";
        licenses += "Copyright 2008 Google Inc.\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "    http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n\n" +
                "limitations under the License.\n\n";

        //Glide
        licenses += "Glide\n";
        licenses += "License for everything not in third_party and not otherwise marked:\n" +
                "\n" +
                "Copyright 2014 Google, Inc. All rights reserved.\n" +
                "\n" +
                "Redistribution and use in source and binary forms, with or without modification, are\n" +
                "permitted provided that the following conditions are met:\n" +
                "\n" +
                "   1. Redistributions of source code must retain the above copyright notice, this list of\n" +
                "         conditions and the following disclaimer.\n" +
                "\n" +
                "   2. Redistributions in binary form must reproduce the above copyright notice, this list\n" +
                "         of conditions and the following disclaimer in the documentation and/or other materials\n" +
                "         provided with the distribution.\n" +
                "\n" +
                "THIS SOFTWARE IS PROVIDED BY GOOGLE, INC. ``AS IS'' AND ANY EXPRESS OR IMPLIED\n" +
                "WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND\n" +
                "FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL GOOGLE, INC. OR\n" +
                "CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR\n" +
                "CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR\n" +
                "SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON\n" +
                "ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING\n" +
                "NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF\n" +
                "ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n" +
                "\n" +
                "The views and conclusions contained in the software and documentation are those of the\n" +
                "authors and should not be interpreted as representing official policies, either expressed\n" +
                "or implied, of Google, Inc.\n" +
                "---------------------------------------------------------------------------------------------\n" +
                "License for third_party/disklrucache:\n" +
                "\n" +
                "Copyright 2012 Jake Wharton\n" +
                "Copyright 2011 The Android Open Source Project\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "   http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n" +
                "limitations under the License.\n" +
                "---------------------------------------------------------------------------------------------\n" +
                "License for third_party/gif_decoder:\n" +
                "\n" +
                "Copyright (c) 2013 Xcellent Creations, Inc.\n" +
                "\n" +
                "Permission is hereby granted, free of charge, to any person obtaining\n" +
                "a copy of this software and associated documentation files (the\n" +
                "\"Software\"), to deal in the Software without restriction, including\n" +
                "without limitation the rights to use, copy, modify, merge, publish,\n" +
                "distribute, sublicense, and/or sell copies of the Software, and to\n" +
                "permit persons to whom the Software is furnished to do so, subject to\n" +
                "the following conditions:\n" +
                "\n" +
                "The above copyright notice and this permission notice shall be\n" +
                "included in all copies or substantial portions of the Software.\n" +
                "\n" +
                "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\n" +
                "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF\n" +
                "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND\n" +
                "NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE\n" +
                "LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION\n" +
                "OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION\n" +
                "WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n" +
                "---------------------------------------------------------------------------------------------\n" +
                "License for third_party/gif_encoder/AnimatedGifEncoder.java and\n" +
                "third_party/gif_encoder/LZWEncoder.java:\n" +
                "\n" +
                "No copyright asserted on the source code of this class. May be used for any\n" +
                "purpose, however, refer to the Unisys LZW patent for restrictions on use of\n" +
                "the associated LZWEncoder class. Please forward any corrections to\n" +
                "kweiner@fmsware.com.\n" +
                "\n" +
                "-----------------------------------------------------------------------------\n" +
                "License for third_party/gif_encoder/NeuQuant.java\n" +
                "\n" +
                "Copyright (c) 1994 Anthony Dekker\n" +
                "\n" +
                "NEUQUANT Neural-Net quantization algorithm by Anthony Dekker, 1994. See\n" +
                "\"Kohonen neural networks for optimal colour quantization\" in \"Network:\n" +
                "Computation in Neural Systems\" Vol. 5 (1994) pp 351-367. for a discussion of\n" +
                "the algorithm.\n" +
                "\n" +
                "Any party obtaining a copy of these files from the author, directly or\n" +
                "indirectly, is granted, free of charge, a full and unrestricted irrevocable,\n" +
                "world-wide, paid up, royalty-free, nonexclusive right and license to deal in\n" +
                "this software and documentation files (the \"Software\"), including without\n" +
                "limitation the rights to use, copy, modify, merge, publish, distribute,\n" +
                "sublicense, and/or sell copies of the Software, and to permit persons who\n" +
                "receive copies from any such party to do so, with the only requirement being\n" +
                "that this copyright notice remain intact.\n\n";

        //Retrofit
        licenses += "Retrofit\n";
        licenses += "Copyright 2013 Square, Inc.\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "   http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n" +
                "limitations under the License.\n\n";

        return licenses;
    }
}