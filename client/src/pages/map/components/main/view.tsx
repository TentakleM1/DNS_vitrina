import React, { useRef } from "react";
import { CreateTusk } from "../create-tusk";
import { CreateStaff } from "../create-stuff";
import { useSelector } from "../../../../shared/store/store";

interface MainProps {
  isTask: boolean
  isStuff: boolean
}

export const Main: React.FC<MainProps> = (props) => {
  const { isTask, isStuff } = props;
  const canvasRef = useRef<HTMLCanvasElement>(null);
  // const [blocks, setBlocks] = useState({});
  const data = useSelector((state) => state);

  // const getBloks = async () => {
  //   try {
  //     const resolve = await fetch("http://localhost:9090/blocks");

  //     if (resolve.status === 200) {
  //       const result = await resolve.json();

  //       setBlocks(result[1]);
  //     }
  //   } catch (error) {
  //     console.error(`Error get bloks: ${error}`);
  //   }
  // };

  // useEffect(() => {
  //   const canvas = canvasRef.current;
  //   if (canvas) {
  //     const ctx = canvas.getContext("2d");
  //     if (ctx) {
  //       // getBloks()
  //       ctx.fillStyle = "#5490de";
  //       ctx.fillRect(0, 10, 30, 400);
  //       ctx.fillStyle = "#781f19";
  //       ctx.fillRect(30, 460, 570, 30);
  //     }
  //   }
  // }, [blocks]);

  return (
    <main className="z-50 h-[40%] flex flex-row items-center justify-around w-full gap-2">
      {isTask ? (
        <CreateTusk />
      ) : isStuff ? (
        <CreateStaff />
      ) : (
        <>
          <div className="h-[400px] p-2 overflow-x-hidden overflow-y-scroll flex-col flex gap-2">
            {data.stuff.stuff.map((card) => {
              if(card.root) return
              return (
                <section className="w-[300px] h-[100px] flex-none flex flex-col items-center gap-2 overflow-hidden border border-orange-500 cursor-pointer rounded-xl duration-500 hover:h-[250px] hover: hover:shadow-lg hover:bg-orange-500 hover:text-amber-50">
                  <div className="flex justify-center items-center">
                    <div className="w-20 h-20 m-2">
                      <img
                        src="https://i.pinimg.com/originals/0a/dd/87/0add874e1ea0676c4365b2dd7ddd32e3.jpg"
                        alt="usm"
                        className="rounded-full"
                      />
                    </div>
                    <div>
                      <span>{`${card.lastName} ${card.name}`}</span>
                    </div>
                  </div>
                  <div>
                    <ul>
                      <li>КБТ</li>
                      <li>Мониторы</li>
                      <li>Мобильные Аксы</li>
                    </ul>
                  </div>
                </section>
              );
            })}
          </div>
          <div className="w-[1000px] h-[400px] border-4 border-orange-400 rounded-xl overflow-y-hidden overflow-x-auto shadow-2xl">
            <canvas ref={canvasRef} width={1000} height={400}></canvas>
          </div>
        </>
      )}
    </main>
  );
};
