import React from "react";

export const CreateTusk: React.FC = () => {
    return (
        <div className="h-[400px] w-full flex justify-around">
                <div className="h-[400px] p-2 overflow-x-hidden overflow-y-scroll flex-col flex gap-2">
                    <section
                        className="w-[300px] h-[100px] flex-none flex flex-col items-center gap-2 overflow-hidden border border-orange-500 cursor-pointer rounded-xl duration-500 hover: hover:shadow-lg hover:bg-orange-500 hover:text-amber-50">
                        <div className="flex justify-center items-center">
                            <div className="w-20 h-20 m-2">
                                <img
                                    src="https://i.pinimg.com/originals/0a/dd/87/0add874e1ea0676c4365b2dd7ddd32e3.jpg"
                                    alt="usm"
                                    className="rounded-full"
                                />
                            </div>
                            <div>
                <span>
                    Ерошенко Дмитрий
                </span>
                            </div>
                        </div>
                    </section>
                </div>
            <section>
                <div className="h-full w-[300px] flex flex-col gap-2 bg-orange-500 rounded-2xl">
                    <div>
                        dsafadsf
                    </div>
                    <div>
                        fdsadf
                    </div>
                </div>
            </section>
            <section className="h-full w-[300px] border-2 rounded-2xl border-orange-500">
fdsaf
            </section>
        </div>
    );
};